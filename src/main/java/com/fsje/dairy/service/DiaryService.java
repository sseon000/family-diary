package com.fsje.dairy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fsje.dairy.common.model.Json;
import com.fsje.dairy.controller.DiaryController;
import com.fsje.dairy.dao.DiaryDao;
import com.fsje.dairy.dto.DiaryDto;
import com.fsje.dairy.dto.FileDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : DiaryService
 * @author : KSH
 * @since  : 2024.06.09
 * @brief  : 다이어리 Service
 */
@Service
@AllArgsConstructor
@Slf4j
public class DiaryService {
	private final DiaryDao diaryDao;
	
	/**
	 * 다이어리 목록 조회
	 * 
	 * @method : diaryList
	 * @author : KSH
	 * @since  : 2024.07.10
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
	 * @param  : {object} DiaryDto diaryDto
	 * @param  : {object} MultipartFile[] diaryFiles
	 * @return : {obejct} Json<HashMap<String, Object>> 
	 */
	public Json<HashMap<String, Object>> diarySave(DiaryDto diaryDto, List<FileDto> fileList) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("diaryDto", diaryDto);
		res.put("fileList", fileList);
		
		// diary save return seq
		diaryDao.dairyInsert(diaryDto);
		int seq = diaryDto.getDiaryId();
		//log.info("### seq, {}", seq);
		
		int i = 0;
		// diary file save
		for(FileDto file : fileList) {
			
			file.setDiaryId(seq);
			
			if(i == 0) {
				file.setIsThumb("1");
			} else {
				file.setIsThumb("0");
			}
			
        	diaryDao.diaryFileInsert(file);
        	i++;
        }
		
		return Json.createSuccessJson(res,"success");
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
