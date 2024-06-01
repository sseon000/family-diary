package com.dbinfocompany.dbinfo.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbinfocompany.dbinfo.domain.member.MemberDto;
import com.dbinfocompany.dbinfo.service.member.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	//의존성 생성자 주입
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	/*
	 * 회원등록 화면
	 */
	@RequestMapping(value = "")
	public String memberForm() {
		return "memberForm";
	}
	
	/*
	 * 회원등록
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//public String registerAdd(MemberDto member, RedirectAttributes rattr) {
	public ResponseEntity<?> memberJoin(MemberDto member) {
		logger.info("member : " + member.toString());
		Map<String,Object> map = new HashMap<>();
		
		try {
			int rowCnt = memberService.write(member);
			
			if(rowCnt != 1) {
				throw new Exception("회원가입 에러(정상인 경우는 1건)");
			}
			
			MemberDto regiMember = memberService.read(member.getId());
			logger.info("regiMember : " + regiMember.toString());
			map.put("msg", "회원가입이 성공했습니다.");
			map.put("member", regiMember);
			return ResponseEntity.ok().body(map);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
			map.put("member", member);
			return ResponseEntity.ok().body(map);
		}
		
	}
	
	
	/*
	 * 회원수정 화면
	 */
	@RequestMapping(value = "/modify")
	public String member(MemberDto memberDto, Model m) {
		logger.info("modify call");
		
		try {
			memberDto = memberService.read(memberDto.getId());
			logger.info(memberDto.toString());
			m.addAttribute("member", memberDto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "memberForm";
	}
	
	/*
	 * 회원수정
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String memberModify(Model m) throws Exception {
		logger.info("modify call");
		return "";
	}

	/*
	 * 회원목록 화면
	 */
	@RequestMapping(value = "/list")
	public String memberList(Model m) throws Exception {
		logger.info("list call");
		
		List<MemberDto> list = memberService.getList();
		m.addAttribute("list", list);
		
		return "list";
	}
	
	/*
	 * 아이디 중복 체크
	 * 회원가입내 유효성 체크 함수로 변경 필요
	 */
    @RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@ResponseBody
	public String doAction(String input_id) {
		String YorN = "N";
		MemberDto dbMember;
		try {
			dbMember = memberService.read(input_id);
			if (dbMember == null) {
				YorN = "Y";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return YorN;
	}
	
}
