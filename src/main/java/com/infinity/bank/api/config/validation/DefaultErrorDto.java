package com.infinity.bank.api.config.validation;

import com.infinity.bank.api.util.DataUtil;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DefaultErrorDto {

	private Integer code;
	private String message;
	private String currentTime;
	
	public DefaultErrorDto(String message) {
		this.message = message;
		this.currentTime = DataUtil.getCurrentTimestamp();
	}
	
	public DefaultErrorDto(Integer code, String message) {
		this(message);
		this.code = code;
	}
	
	
}
