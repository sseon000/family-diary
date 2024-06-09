package com.fsje.dairy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fsje.dairy.dto.DiaryDto;
import com.fsje.dairy.service.DiaryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : DiaryController
 * @author : KSH
 * @brief  : 다이어리 Controller
 * @see    : N/A
 * @todo   : N/A
 * @since  : 2024.06.02
 */
@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("diary")
public class DiaryController {
	private final DiaryService diaryService;
	
	@RequestMapping("")
	public String main() {
		log.info("hello, {}", "DiaryController");
		return "diary/diaryMain";
	}
	
	/**
	 * @method   : getDiaryList
	 * @author : KSH
	 * @since  : 2024.06.09
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	@RequestMapping("/getDiaryList")
	public ModelAndView getDiaryList(@RequestBody DiaryDto diaryDto) {
		ModelAndView mav = new ModelAndView();
		List<DiaryDto> diaryList = diaryService.getDiaryList(diaryDto);
		mav.addObject("diaryList", diaryList);
		mav.setViewName("page/diary/diaryMain");
		
		return mav;
	}
}
