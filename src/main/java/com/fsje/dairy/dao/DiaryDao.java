package com.fsje.dairy.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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
	 * 다이어리 목록 조회
	 * 
	 * @method : diaryList
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	public List<DiaryDto> diaryList(DiaryDto diaryDto) {
		return sqlSessionTemplate.selectList("diaryDao.diarySelect", diaryDto);
	}
	
	/**
	 * 다이어리 등록
	 * 
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
	 * 다이어리 상세 조회
	 * 
	 * @method : diarydetail
	 * @author : KSH
	 * @since  : 2024.06.30
	 * @param  : {long} diaryId
	 * @return : {object} DiaryDto
	 */
	public DiaryDto diaryDetail(String diaryId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("diaryId", diaryId);
		return sqlSessionTemplate.selectOne("diaryDao.diarySelectOne", map);
	}
	
	/**
	 * 다이어리 수정
	 * 
	 * @method : diaryModify
	 * @author : KSH
	 * @since  : 2024.07.01
	 * @param  : {obejct} DiaryDto
	 * @return : {int} 
	 */
	public int diaryModify(DiaryDto diaryDto) {
		return sqlSessionTemplate.update("diaryDao.dairyUpdate", diaryDto);
	}
}
