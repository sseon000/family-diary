package com.fsje.dairy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsje.dairy.common.model.Json;
import com.fsje.dairy.dto.UserDto;
import com.fsje.dairy.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : UserController
 * @author : KSH
 * @brief  : 유저 Controller
 * @see    : N/A
 * @todo   : 회원중복확인, 수정, 조회, 삭제
 * @since  : 2024.06.09
 */
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	/**
	 * @method : pageSignup
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {} 
	 * @return : {string} page/user/signupForm
	 */
	@GetMapping("")
	public String pageSignup(UserDto userDto) {
		log.info("hello, {}", "UserController.pageSignup");
		return "page/user/signupForm";
	}
	
	/**
	 * @method : signup
	 * @author : KSH
	 * @since  : 2024.07.20
	 * @param  : {UserDto} userDto 
	 * @param  : {Model} model 
	 * @return : {string} page/user/signupForm
	 */
	@PostMapping("/signup")
	public String signup(UserDto userDto, Model model) {
		log.info("userDto, {}", userDto.toString());
		//구글 이메일 인증 추가 필요 2024.07.20
		
		//리다이렉트 페이지
		String redirectPage = "redirect:/";
		model.addAttribute("msg", "회원가입이 완료됐습니다.");
		
		try {
			if("admin".equals(userDto.getUserId())) {
				userDto.setRole("ADMIN");
			} else {
				userDto.setRole("USER");
			}
			
			//1. 회원가입
			Json<UserDto> json = userService.userSave(userDto);
			if(!"success".equals(json.getMessageCode())) {
				throw new Exception("회원가입에 실패했습니다. 관리자에게 문의 부탁드립니다.");
			}
			
		} catch(Exception e) {
			redirectPage = "redirect:page/user/signupForm";
			model.addAttribute("msg", e.getMessage());
			return redirectPage;
		}
		
		//2. 페이지 이동
		return redirectPage;
	}
	
	/**
	 * @method : 사용자ID 중복체크
	 * @author : KSH
	 * @since  : 2024.07.20
	 * @param  : {UserDto} userDto 
	 * @return : {string} msg
	 */
	@PostMapping("/isExistUserId")
	@ResponseBody
	public Json<Map<String, String>> isExistUserId(@RequestBody UserDto userDto) {
		log.info("userDto, {}", userDto.toString());
		Map<String, String> output = new HashMap<>();
		String isExists = userService.isExistUserId(userDto.getUserId());
		
		output.put("checkedId", userDto.getUserId());
		output.put("isExists", isExists);
		return Json.createSuccessJson(output, "code123");
	}
}
