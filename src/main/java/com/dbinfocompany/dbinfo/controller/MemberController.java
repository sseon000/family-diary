package com.dbinfocompany.dbinfo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbinfocompany.dbinfo.domain.MemberDto;
import com.dbinfocompany.dbinfo.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "member")
	public String member(Model m) {
		logger.info("member call");
		
		try {
			MemberDto memberDto = memberService.read("ghdrlfehd");
			logger.info(memberDto.toString());
			m.addAttribute("member", memberDto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "member";
	}
	
	@RequestMapping(value = "list")
	public String memberList(Model m) throws Exception {
		logger.info("list call");
		
		List<MemberDto> list = memberService.getList();
		m.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping(value = "detail")
	public String memberDetail(MemberDto memberDto, Model m) throws Exception {
		logger.info("detail call");
		logger.info("memberDto : " + memberDto);
		MemberDto memberDetail = memberService.read(memberDto.getId());
		m.addAttribute("member", memberDetail);
		return "detail";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String memberModify(Model m) throws Exception {
		logger.info("modify call");
		return "";
	}
	
	/*
	@RequestMapping(value = "/member2")
    @ResponseBody
    public Member test(@RequestBody Member m) {
		logger.info("m = " + m);
        m.setMemberId("ghdrlfehd");
        m.setMemberName("홍길동");

        return m;
    }
    */
}
