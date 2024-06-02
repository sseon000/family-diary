package com.fsje.dairy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @file   : MainController
 * @author : KSH
 * @brief  : 프로젝트 메인 컨트롤러
 * @see    : N/A
 * @todo   : N/A
 * @since  : 2024.06.02
 */

@Controller
@Slf4j
public class MainController {
	@RequestMapping("")
	public String main() {
		log.info("hello, {}", "MainController");
		return "main";
	}
}
