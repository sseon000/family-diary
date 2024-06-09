package com.fsje.dairy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsje.dairy.dao.DiaryDao;
import com.fsje.dairy.dto.DiaryDto;

import lombok.AllArgsConstructor;

/**
 * @file   : DiaryService
 * @author : KSH
 * @brief  : 다이어리 Service
 * @see    : N/A
 * @todo   : N/A
 * @since  : 2024.06.09
 */
@Service
@AllArgsConstructor
public class DiaryService {
	private final DiaryDao diaryDao;
	
	/**
	 * @method   : getDiaryList
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	public List<DiaryDto> getDiaryList(DiaryDto diaryDto) {
		return diaryDao.selectDiaryList(diaryDto);
	}
}
