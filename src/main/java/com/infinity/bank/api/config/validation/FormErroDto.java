package com.infinity.bank.api.config.validation;

public class FormErroDto {
	
	private String field;
	private String erro;
	
	public FormErroDto(String field, String erro) {
		super();
		this.field = field;
		this.erro = erro;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}


}
