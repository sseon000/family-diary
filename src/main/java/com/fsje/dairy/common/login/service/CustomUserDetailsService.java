package com.fsje.dairy.common.login.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fsje.dairy.common.login.dto.CustomUserDetails;
import com.fsje.dairy.dao.UserDao;
import com.fsje.dairy.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private final UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//로그인사용자가 등록된 사용자 인지 확인
		UserDto userDto = userDao.findByUserName(userName);
		//db로부터 사용자 아이디가 있는지 여부를 확인
		if(userDto == null) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		
		return new CustomUserDetails(userDto);
	}
}
