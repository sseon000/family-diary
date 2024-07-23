package com.fsje.dairy.common.login.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fsje.dairy.dto.UserDto;

public class CustomUserDetails implements UserDetails {
	@Autowired
	private UserDto userDto;	
	
	public CustomUserDetails(UserDto userDto) {
		this.userDto = userDto;
	}
	
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
