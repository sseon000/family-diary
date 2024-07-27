package com.fsje.dairy.common.login.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fsje.dairy.dao.UserDao;
import com.fsje.dairy.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserDto userDto;	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authoritys = new ArrayList<>();
		
		authoritys.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return userDto.getRole();
			}
		});
		
		return authoritys;
	}

	@Override
	public String getPassword() {
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		return userDto.getUserName();
	}

}
