package com.fsje.dairy.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fsje.dairy.common.model.Json;
import com.fsje.dairy.dao.UserDao;
import com.fsje.dairy.dto.UserDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : UserService
 * @author : KSH
 * @since  : 2024.07.20
 * @brief  : 유저 Service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	private final UserDao userDao;
	
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 회원 등록
	 * 
	 * @method : userSave
	 * @author : KSH
	 * @since  : 2024.07.20
	 * @param  : {UserDto} userDto
	 * @return : {Json<UserDto>} json 
	 */
	public Json<UserDto> userSave(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userDao.userInsert(userDto);
		
		return Json.createSuccessJson(userDto,"success");
	}
	
}
