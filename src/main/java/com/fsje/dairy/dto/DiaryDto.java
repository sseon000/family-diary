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
	private long diaryId;
	private String diaryTitle;
	private String diaryContent;
	private String regUserId;
	private String regAt;
	private String modiUserId;
	private String modiAt;
}