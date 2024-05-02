package com.dbinfocompany.dbinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
			MemberDto memberDto = memberService.getMember("ghdrlfehd");
			logger.info(memberDto.toString());
			m.addAttribute("member", memberDto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "member";
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
