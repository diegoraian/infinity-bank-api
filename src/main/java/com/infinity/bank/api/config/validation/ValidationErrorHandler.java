package com.infinity.bank.api.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infinity.bank.api.BusinessException;

@RestControllerAdvice
public class ValidationErrorHandler {
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErroDto> handle(MethodArgumentNotValidException exception) {
		List<FormErroDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			FormErroDto erro = new FormErroDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public DefaultErrorDto handle(HttpMessageNotReadableException exception) {
		DefaultErrorDto erro = new DefaultErrorDto(400, "Bad Request");	
		return erro;
	}	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadCredentialsException.class)
	public DefaultErrorDto handle(BadCredentialsException exception) {
		DefaultErrorDto erro = new DefaultErrorDto(400, "Not Authorized");	
		return erro;
	}	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(LockedException.class)
	public DefaultErrorDto handle(LockedException exception) {
		return new DefaultErrorDto(400, exception.getMessage());
	}	

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusinessException.class)
	public DefaultErrorDto handle(BusinessException exception) {
		return new DefaultErrorDto(405, exception.getMessage());
	}
	
}
