package com.fsje.dairy.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fsje.dairy.common.model.Json;
import com.fsje.dairy.dto.DiaryDto;
import com.fsje.dairy.dto.DiaryResDto;
import com.fsje.dairy.dto.FileDto;
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
@PropertySource("application.properties") //값을 사용할 properties file 지정 
@Slf4j
@RequestMapping("/diary")
public class DiaryController {
	@Value("${uploadPath}") //${}을 키로 값을 읽어옴
    private String uploadPath;
	
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
	public String pageDiaryList() {
		log.info("### DiaryController.pageDiaryList, {}", "pageDiaryList");
		return "page/diary/DiaryMain";
	}
	
	/**
	 * 다이어리 등록 화면
	 * 
	 * @method : pageDiaryForm
	 * @author : KSH
	 * @since  : 2024.06.25
	 * @param  : {}
	 * @return : {sting} page/diary/diarySave
	 */
	@GetMapping(value = "/reg")
	public String pageDiaryForm() {
		log.info("### DiaryController.pageDiaryForm, {}", "pageDiaryForm");
		
		return "page/diary/DiaryForm";
	}
	
	/**
	 * 다이어리 수정 화면
	 * 
	 * @method : pageDiaryDetailForm
	 * @author : KSH
	 * @since  : 2024.06.30
	 * @param  : {string} diaryId
	 * @return : {sting} page/diary/diarySave
	 */
	@GetMapping(value = "/detail")
	public String pageDiaryDetailForm(@RequestParam("diaryId") String diaryId, Model m) {
		log.info("### DiaryController.pageDiaryDetailForm, {}", "pageDiaryDetailForm");
		DiaryDto detailDiaryDto = diaryService.diaryDetail(diaryId);
		m.addAttribute("diaryDto", detailDiaryDto);
		
		return "page/diary/DiaryForm";
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
	 * 다이어리 목록 조회 테스트
	 * 
	 * @method : diaryList
	 * @author : KSH
	 * @since  : 2024.07.10
	 * @param  : {obejct} DiaryDto
	 * @return : {list} List<DiaryDto>
	 */
	@PostMapping(value = "")
	@ResponseBody
	public List<DiaryResDto> diaryListTest(@RequestBody DiaryDto diaryDto) {
		log.info("### DiaryController.diaryDto, {}", diaryDto.toString());
		List<DiaryResDto> diaryList = diaryService.diaryListTest(diaryDto);
		return diaryList;
	}
	
	/**
	 * 다이어리 등록
	 * 
	 * @method : diarySave
	 * @author : KSH
	 * @since  : 2024.06.25
	 * @param  : {object} DiaryDto
	 * @return : {object} Json<DiaryDto> 
	 */
	@PutMapping(value = "/reg")
	@ResponseBody
	public Json<DiaryDto> diarySave(@RequestBody DiaryDto diaryDto) {
		log.info("### DiaryController.diaryDto, {}", diaryDto.toString());
		int rowCnt = diaryService.diarySave(diaryDto);
		
		return Json.createSuccessJson(diaryDto, "code123");
	}
	
	/**
	 * 다이어리 수정
	 * 
	 * @method : diaryModify
	 * @author : KSH
	 * @since  : 2024.07.01
	 * @param  : {object} DiaryDto
	 * @return : {object} Json<DiaryDto> 
	 */
	@PutMapping(value = "/modify")
	@ResponseBody
	public Json<DiaryDto> diaryModify(@RequestBody DiaryDto diaryDto) {
		log.info("### DiaryController.diaryDto, {}", diaryDto.toString());
		int rowCnt = diaryService.diaryModify(diaryDto);
		
		return Json.createSuccessJson(diaryDto, "code123");
	}
	
	/**
	 * 다이어리 화면
	 * 
	 * @method : pageDiaryList
	 * @author : KSH
	 * @since  : 2024.06.02
	 * @param  : {} 
	 * @return : {sting} page/diary/diaryMain
	 */
	@GetMapping(value = "/diaryFile")
	public String pageDiaryFileList() {
		log.info("### DiaryController.pageDiaryList, {}", "pageDiaryList");
		return "page/diary/DiaryFile";
	}
    
    @PostMapping(value = "/uploadFileTest")
    @ResponseBody
    public Json<List<FileDto>> uploadFileTest(@RequestPart("diaryFiles") MultipartFile[] diaryFiles
    										, @RequestPart("diaryDto") DiaryDto diaryDto) {
    	
    	log.info("### DiaryController.uploadFileTest.diaryDto, {}", diaryDto.toString());
    	List<FileDto> fileList = new ArrayList<>();
    	
        for(MultipartFile uploadFile : diaryFiles) {
            //파일 확장자 체크
        	//String extension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
            if(uploadFile.getContentType().startsWith("image") == false) {
                log.warn("this is not image type");
                return null;
            }
            
            String originalName = uploadFile.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
            String extension = StringUtils.getFilenameExtension(originalName);
            
            log.info("### uploadFileTest.fileName, {}", fileName);

            //폴더 구분
            String folderPath = makeFolder();
            String uuid = UUID.randomUUID().toString();

            //파일명 구분
            //String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
            String newFileName = uuid + "." + extension;
            String saveName = uploadPath + File.separator + folderPath + File.separator + newFileName;
            Path savePath = Paths.get(saveName);
            try {
                uploadFile.transferTo(savePath);
                FileDto fileDto = new FileDto();
                fileDto.setFileName(newFileName);
                fileDto.setFilePath(saveName);
                fileDto.setIsThumb("1");
                fileList.add(fileDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            for(FileDto file : fileList) {
            	log.info("### uploadFileTest.file, {}", file.toString());
            }
        }
        
        return Json.createSuccessJson(fileList,"uploadSuccess"); 
    }
    
    @PutMapping(value = "/uploadFile")
    @ResponseBody
    public Json<List<FileDto>> uploadFile(@RequestParam("uploadFiles") MultipartFile[] uploadFiles) {
    	
    	List<FileDto> fileList = new ArrayList<>();
        for(MultipartFile uploadFile : uploadFiles) {

            //파일 확장자 체크
        	//String extension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
            if(uploadFile.getContentType().startsWith("image") == false) {
                log.warn("this is not image type");
                return null;
            }
            

            String originalName = uploadFile.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
            String extension = StringUtils.getFilenameExtension(originalName);

            log.info("fileName " +fileName);

            //폴더 구분
            String folderPath = makeFolder();
            String uuid = UUID.randomUUID().toString();

            //파일명 구분
            //String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
            String newFileName = uuid + "." + extension;
            String saveName = uploadPath + File.separator + folderPath + File.separator + newFileName;
            Path savePath = Paths.get(saveName);
            try {
                uploadFile.transferTo(savePath);
                FileDto fileDto = new FileDto();
                fileDto.setFileName(newFileName);
                fileDto.setFilePath(folderPath);
                fileList.add(fileDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return Json.createSuccessJson(fileList,"uploadSuccess"); 
    }

    /**
     * @todo util 패키지로 옮기기
     * 
     */
    private String makeFolder(){
        String folderPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        //String folderPath = str.replace("//", File.separator);

        File uploadPathFolder = new File(uploadPath, folderPath);

        if(uploadPathFolder.exists() == false) {
            uploadPathFolder.mkdirs();
        }

        return folderPath;
    }
}
