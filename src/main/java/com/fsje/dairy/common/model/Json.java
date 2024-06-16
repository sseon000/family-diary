package com.fsje.dairy.common.model;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

/**
 * @file   : Json<T>
 * @author : KSH
 * @brief  : response json
 * @see    : N/A
 * @todo   : msgCd Enum만들기, builder pattern 주석
 * @since  : 2024.06.16
 */
@Getter
@Builder
public class Json<T> {
	private Integer status;
	private String msgCd;
	private T result;
	
	public static <T> Json<T> res(T result) {
		return res(result, null, null); 
	}
	
	public static <T> Json<T> res(T result, String msgCd) {
		return res(result, msgCd, null); 
	}
	
	public static <T> Json<T> res(T result, String msgCd, HttpStatus status) {
		return Json.<T>builder().result(result).status(HttpStatus.OK.value()).msgCd(msgCd).build();
	}
}
