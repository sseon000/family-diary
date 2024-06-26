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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @file   : DiaryController
 * @author : KSH
 * @since  : 2024.06.02
 * @brief  : 다이어리 Controller
 */
@Controller
@RequiredArgsConstructor //초기화 되지 않은 final필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자 생성
@Slf4j
@RequestMapping("/diary")
public class DiaryController {
	/**
	 * 의존성 주입(DI) : 생성자, setter, 필드 
	 * 생성자 주입 권장
	 * 1. 객체의 불변성 확보 : 생성자는 호출 시점에 1회만 호출됨
	 * 2. 테스트 코드의 작성 : 스프링의 의존성 주입을 맡기지 않고 순수 자바 코드를 이용할 수 있음
	 * 3. lombok + @Autowired 생략 : lombok의 RequiredArgsConstructor를 이용해 생성자 방식 의존성 주입 + 생성자가 1개만 있을경우 @Autowired 생략
	 * 4. 순환 참조 에러 방지 :
	 */
	private final DiaryService diaryService;
	
	/**
	 * 다이어리 화면
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
		return "page/diary/DiaryMain";
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
		
		return "page/diary/DiarySave";
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
	@PutMapping(value = "")
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
