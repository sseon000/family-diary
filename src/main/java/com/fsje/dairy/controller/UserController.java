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
	@ResponseBody
	public Json<Map<String, String>> signup(@RequestBody UserDto userDto) {
		log.info("userDto, {}", userDto.toString());
		Map<String, String> output = new HashMap<>();
		
		try {
			//1. 중복회원 체크
			String isExists = userService.isExistUserId(userDto.getUserId());
			if("1".equals(isExists)) {
				throw new Exception("중복된 ID입니다.");
			}
			
			//2. 회원가입
			Json<UserDto> json = userService.userSave(userDto);
			if(!"success".equals(json.getMessageCode())) {
				throw new Exception("회원가입에 실패했습니다. 관리자에게 문의 부탁드립니다.");
			}
			
			//3. 회원권한 설정
			if("admin".equals(userDto.getUserId())) {
				userDto.setRole("ADMIN");
			} else {
				userDto.setRole("USER");
			}
			
		} catch(Exception e) {
			output.put("msg", e.getMessage());
			return Json.createSuccessJson(output, "error");
		}
		
		output.put("msg", "회원가입 성공");
		return Json.createSuccessJson(output, "success");
	}
	
	/**
	 * @method : 구글 이메일 인증
	 * @author : KSH
	 * @since  : 2024.07.27
	 * @param  : {UserDto} userDto 
	 * @return : {string} msg
	 */
	@PostMapping("/authEmail")
	@ResponseBody
	public Json<Map<String, String>> authEmail(@RequestBody UserDto userDto) {
		log.info("userDto, {}", userDto.toString());
		Map<String, String> output = new HashMap<>();
		//구글 이메일 인증 추가 필요 2024.07.27
		
		return Json.createSuccessJson(output, "success");
	}
}
