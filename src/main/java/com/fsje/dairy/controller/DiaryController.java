package com.fsje.dairy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsje.dairy.dto.DiaryDto;
import com.fsje.dairy.service.DiaryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : DiaryController
 * @author : KSH
 * @since  : 2024.06.02
 * @brief  : 다이어리 Controller
 */
@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/diary")
public class DiaryController {
	private final DiaryService diaryService;
	
	/**
	 * 다이어리 메인 화면
	 * 
	 * @method : pageDiaryList
	 * @author : KSH
	 * @since  : 2024.06.02
	 * @param  : {} 
	 * @return : {sting} page/diary/diaryMain
	 */
	@GetMapping("")
	public String pageDiaryList(DiaryDto diaryDto) {
		log.info("### DiaryController.pageDiaryList, {}", "pageDiaryList");
		return "page/diary/diaryMain";
	}
	
	/**
	 * 다이어리 등록 화면
	 * 
	 * @method : pageDiarySave
	 * @author : KSH
	 * @since  : 2024.06.25
	 * @param  : {}
	 * @return : {sting} page/diary/diarySave
	 */
	@GetMapping(value = "/save")
	public String pageDiarySave(DiaryDto diaryDto) {
		log.info("### DiaryController.pageDiarySave, {}", "pageDiarySave");
		return "page/diary/diarySave";
	}
	
	/**
	 * 다이어리 목록 조회
	 * 
	 * @method : diaryList
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	@PutMapping(value = "/list")
	@ResponseBody
	public List<DiaryDto> diaryList(@RequestBody DiaryDto diaryDto) {
		log.info("### DiaryController.diaryDto, {}", diaryDto.toString());
		List<DiaryDto> diaryList = diaryService.diaryList(diaryDto);
		return diaryList;
	}
	
	/**
	 * 다이어리 등록
	 * 
	 * @method : diarySave
	 * @author : KSH
	 * @since  : 2024.06.25
	 * @param  : {}
	 * @return : {sting} 
	 */
	@PutMapping(value = "/save")
	@ResponseBody
	public String diarySave(@RequestBody DiaryDto diaryDto) {
		log.info("### DiaryController.diaryDto, {}", diaryDto.toString());
		//int rowCnt = diaryService.saveDiary(diaryDto);
		
		return "성공";
	}
}
