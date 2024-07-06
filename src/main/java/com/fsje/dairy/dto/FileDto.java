package com.fsje.dairy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @file   : FileDto
 * @author : KSH
 * @brief  : 파일 DTO
 * @see    : N/A
 * @since  : 2024.07.06
 */
@Data
@AllArgsConstructor
public class FileDto {
	private Integer diaryFileId;
	private Integer diaryId;
	private String fileName;
	private String filePath;
	private String regUser;
	private String regAt;
	private String modiUser;
	private String modiAt;
}