package com.fsje.dairy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsje.dairy.common.model.Json;
import com.fsje.dairy.common.util.MailService;
import com.fsje.dairy.common.util.Utils;
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
	private final MailService mailService;
	
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
	 * @todo   : 구글 이메일 인증 추가
	 * @return : {Json} msg
	 */
	@PostMapping("/authEmail")
	@ResponseBody
	public Json<Map<String, String>> authEmail(@RequestBody UserDto userDto) {
		log.info("userDto, {}", userDto.toString());
		Map<String, String> output = new HashMap<>();
		//구글 이메일 인증 추가 필요 2024.07.27
		String subject = "[😀] 이메일 인증 메일입니다.";
		String body = "안녕하세요?\r\n이메일 인증코드가 발급되었습니다. 아래 인증코드를 홈페이지 인증코드란에 입력해주세요.\r\n인증코드 : " + "1001";
		mailService.sendEmail(userDto.getEmail(), subject, body);
		
		return Json.createSuccessJson(output, "success");
	}
	
	/**
	 * @method : 패스워드 찾기
	 * @author : KSH
	 * @since  : 2024.08.17
	 * @param  : {UserDto} userDto 
	 * @todo   : mail message constant로 빼기
	 * @return : {Json} msg
	 */
	@PostMapping("/findPassword")
	@ResponseBody
	public Json<Map<String, String>> findPassword(@RequestBody UserDto userDto) {
		log.info("userDto, {}", userDto.toString());
		Map<String, String> output = new HashMap<>();
		try {
			//1. 입력받은 아이디와 이메일주소로 검색한 아이디가 같은지 검증
			String userEmail = userDto.getEmail();
			
			//String dbEmail = userService.checkIdEmail();
			
			//2. 조회 결과가 없거나, 이메일이 다를 경우 fail
			//if(dbEmail = null || !userEmail.equals(dbEmail)) {
			//
			//}
			
			//3-1. 신규 비밀번호 생성
			String tempPassword = Utils.getKey(false, 6);
			//3-2. 신규 비밀번호로 회원정보 수정
			//userService.updatePassword(tempPassword);
			
			//3-3. 이메일 전송(mail message constant로 빼기)
			String subject = "[😀] 알림 메일입니다.";
			String body = "안녕하세요?\r\n신규 비밀번호가 생성되었습니다. 아래 신규 비밀번호로 로그인하시고, 비밀번호 수정 부탁드립니다.\r\n신규 비밀번호 : " + tempPassword;
			//mailService.sendEmail(dbEmail, subject, body);
			
		} catch(Exception e) {
			e.getMessage();
		}
		
		return Json.createSuccessJson(output, "success");
	}
}
