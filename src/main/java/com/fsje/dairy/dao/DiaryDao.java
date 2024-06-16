package com.fsje.dairy.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.fsje.dairy.controller.DiaryController;
import com.fsje.dairy.dto.DiaryDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : DiaryDao
 * @author : KSH
 * @brief  : 다이어리 DAO
 * @see    : N/A
 * @since  : 2024.06.09
 */
@Repository
@AllArgsConstructor
@Slf4j
public class DiaryDao {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @method   : DiaryDao
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {class} DiaryDto
	 * @return : {Integer} int
	 */
	public int insertDairy(DiaryDto diaryDto) {
		return sqlSessionTemplate.insert("insertDairy", diaryDto);
	}
	
	/**
	 * @method   : selectDiaryList
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	public List<DiaryDto> selectDiaryList(DiaryDto diaryDto) {
		log.info(diaryDto.toString());
		return sqlSessionTemplate.selectList("diaryDao.selectDiaryList", diaryDto);
	}
}
