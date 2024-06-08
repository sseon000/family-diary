package com.fsje.dairy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @file   : DiaryController
 * @author : KSH
 * @brief  : 다이어리 컨트롤러
 * @see    : N/A
 * @todo   : 서비스호출
 * @since  : 2024.06.02
 */
@Controller
@Slf4j
@RequestMapping("diary")
public class DiaryController {
	@RequestMapping("")
	public String main() {
		log.info("hello, {}", "DiaryController");
		return "diary/diaryMain";
	}
}
