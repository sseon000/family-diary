package com.fsje.dairy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fsje.dairy.dto.DiaryDto;
import com.fsje.dairy.service.DiaryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : LoginController
 * @author : KSH
 * @brief  : 로그인 Controller
 * @see    : N/A
 * @todo   : N/A
 * @since  : 2024.06.09
 */
@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {
	//private final DiaryService diaryService;
	
	/**
	 * @method   : pageLogin
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {} 
	 * @return : {string} page/member/loginForm
	 */
	@RequestMapping("")
	public String pageLogin() {
		log.info("hello, {}", "LoginController.pageLogin");
		return "page/login/loginForm";
	}
}
