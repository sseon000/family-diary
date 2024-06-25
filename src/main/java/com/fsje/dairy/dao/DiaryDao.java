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
 * @since  : 2024.06.09
 * @brief  : 다이어리 DAO
 */
@Repository
@AllArgsConstructor
@Slf4j
public class DiaryDao {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @method : diaryInsert
	 * @author : KSH
	 * @since  : 2024.06.25
	 * @param  : {obejct} DiaryDto
	 * @return : {Integer} int
	 */
	public int dairyInsert(DiaryDto diaryDto) {
		return sqlSessionTemplate.insert("diaryDao.dairyInsert", diaryDto);
	}
	
	/**
	 * @method : diarySelect
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	public List<DiaryDto> diarySelect(DiaryDto diaryDto) {
		return sqlSessionTemplate.selectList("diaryDao.diarySelect", diaryDto);
	}
}
