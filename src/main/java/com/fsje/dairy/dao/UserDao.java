package com.fsje.dairy.dao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.fsje.dairy.dto.UserDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : UserDao
 * @author : KSH
 * @since  : 2024.07.20
 * @brief  : 유저 DAO
 */
@Repository
@RequiredArgsConstructor
@Slf4j
public class UserDao {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 회원 등록
	 * 
	 * @method : userInsert
	 * @author : KSH
	 * @since  : 2024.7.20
	 * @param  : {UserDto} userDto
	 * @return : {int} 
	 */
	public int userInsert(UserDto userDto) {
		return sqlSessionTemplate.insert("userDao.userInsert", userDto);
	}
	
	/**
	 * 회원 인증
	 * 
	 * @method : findByUserId
	 * @author : KSH
	 * @since  : 2024.7.23
	 * @param  : {string} userId
	 * @return : {User} user 
	 */
	public UserDto findByUserId(String userId) {
		return sqlSessionTemplate.selectOne("userDao.findByUserId", userId);
	}
	
	/**
	 * 회원 중복 체크
	 * 
	 * @method : isExistUserId
	 * @author : KSH
	 * @since  : 2024.07.20
	 * @param  : {string} userId
	 * @return : {string} "1", "0" 
	 */
	public String isExistUserId(String userId) {
		return sqlSessionTemplate.selectOne("userDao.isExistUserId", userId);
	}
	
}
