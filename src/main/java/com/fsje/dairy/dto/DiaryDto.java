package com.fsje.dairy.dto;

import lombok.Data;

@Data
public class DiaryDto {
	private Integer diaryId;
	private String diaryTitle;
	private String diaryContent;
	private String regUserId;
	private String regAt;
	private String modiUserId;
	private String modiAt;
}