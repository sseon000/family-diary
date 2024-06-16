package com.fsje.dairy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsje.dairy.dto.DiaryDto;
import com.fsje.dairy.service.DiaryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : DiaryController
 * @author : KSH
 * @brief  : 다이어리 Controller
 * @see    : N/A
 * @todo   : response json dev
 * @since  : 2024.06.02
 */
@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/diary")
public class DiaryController {
	private final DiaryService diaryService;
	
	@RequestMapping("")
	public String main(DiaryDto diaryDto) {
		log.info("hello, {}", "DiaryController");
		return "page/diary/diaryMain";
	}
	
	/**
	 * @method   : getDiaryList
	 * @author : KSH
	 * @param <T>
	 * @since  : 2024.06.09
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	@RequestMapping(value = "/getDiaryList", method = RequestMethod.PUT)
	@ResponseBody
	public List<DiaryDto> getDiaryList(@RequestBody DiaryDto diaryDto) {
		log.info(diaryDto.toString());
		List<DiaryDto> diaryList = diaryService.getDiaryList(diaryDto);
		return diaryList;
	}
}
