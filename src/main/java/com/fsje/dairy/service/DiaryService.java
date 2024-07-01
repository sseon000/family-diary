package com.fsje.dairy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsje.dairy.common.model.Json;
import com.fsje.dairy.dao.DiaryDao;
import com.fsje.dairy.dto.DiaryDto;

import lombok.AllArgsConstructor;

/**
 * @file   : DiaryService
 * @author : KSH
 * @since  : 2024.06.09
 * @brief  : 다이어리 Service
 */
@Service
@AllArgsConstructor
public class DiaryService {
	private final DiaryDao diaryDao;
	
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
		return diaryDao.diaryList(diaryDto);
	}
	
	/**
	 * 다이어리 등록
	 * 
	 * @method : diarySave
	 * @author : KSH
	 * @since  : 2024.06.29
	 * @param  : {obejct} DiaryDto
	 * @return : {int} 
	 */
	public int diarySave(DiaryDto diaryDto) {
		return diaryDao.dairyInsert(diaryDto);
	}

	/**
	 * 다이어리 상세
	 * 
	 * @method : diaryDetail
	 * @author : KSH
	 * @since  : 2024.06.30
	 * @param  : {long} diaryId
	 * @return : {objec} DiaryDto 
	 */
	public DiaryDto diaryDetail(String diaryId) {
		return diaryDao.diaryDetail(diaryId);
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
		return diaryDao.diaryModify(diaryDto);
	}
}
