package com.fsje.dairy.dto;

import lombok.Data;

/**
 * @file   : DiaryResDto
 * @author : KSH
 * @brief  : 다이어리 RES DTO
 * @see    : N/A
 * @since  : 2024.07.10
 */
@Data
public class DiaryResDto {
	private Integer diaryId;
	private String diaryTitle;
	private String diaryContent;
	private String filePath;
	private String regUser;
	private String regAt;
	private String modiUser;
	private String modiAt;
}