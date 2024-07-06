package com.fsje.dairy.dto;

import lombok.Data;

/**
 * @file   : DiaryDto
 * @author : KSH
 * @brief  : 다이어리 DTO
 * @see    : N/A
 * @since  : 2024.06.09
 */
@Data
public class DiaryDto {
	/*
	 * int, long -> Interger, Long 타입을 선언한 이유 : 
	 * int, long은 primitive type이라 초기화시 0값을 가짐
	 * 의도적으로 0값을 할당한건지 초기화된 0값인지 알 수 없으므로
	 * wrapper class(Integer, Long)를 사용해 초기화시 null이 지정되게함
	 */
	private Integer diaryId;
	private String diaryTitle;
	private String diaryContent;
	private String regUser;
	private String regAt;
	private String modiUser;
	private String modiAt;
}