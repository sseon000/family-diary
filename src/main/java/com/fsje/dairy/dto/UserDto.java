package com.fsje.dairy.dto;

import lombok.Data;

/**
 * @file   : UserDto
 * @author : KSH
 * @brief  : 유저 DTO
 * @see    : N/A
 * @since  : 2024.06.09
 */
@Data
public class UserDto {
	private String userId;
	private String password;
	private String userName;
	private String email;
	private String familyId;
}
