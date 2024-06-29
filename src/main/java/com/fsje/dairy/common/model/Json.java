package com.fsje.dairy.common.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * @file   : Json<T>
 * @author : KSH
 * @since  : 2024.06.16
 * @brief  : response json
 */
@Getter
public class Json<T> {
	private Integer status;
	private String message;
	private String messageCode;
	private T result;
	
	static public <T> Json<T> createSuccessJson(T result, String messageCode) {
		Json<T> json = new Json<T>();
		json.setResult(result).setStatus(HttpStatus.OK.value()).setMessageCode(messageCode);
		return json;
	}
	
	public Json<T> setResult(T result) {
		this.result = result;
		return this;
	}
	
	public Json<T> setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Json<T> setMessageCode(String messageCode) {
		this.messageCode = messageCode;
		return this;
	}
}
