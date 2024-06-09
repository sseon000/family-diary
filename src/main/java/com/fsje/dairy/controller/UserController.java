package com.fsje.dairy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsje.dairy.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : UserController
 * @author : KSH
 * @brief  : 유저 Controller
 * @see    : N/A
 * @todo   : N/A
 * @since  : 2024.06.09
 */
@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("user")
public class UserController {
	//private final DiaryService diaryService;
	
	/**
	 * @method   : pageSignup
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {} 
	 * @return : {string} page/user/signupForm
	 */
	@RequestMapping("")
	public String pageSignup(UserDto userDto) {
		log.info("hello, {}", "UserController.pageSignup");
		return "page/user/signupForm";
	}
}
