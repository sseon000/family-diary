package com.dbinfocompany.dbinfo.controller;

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
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	private final MemberService memberService;
	
	@Autowired
	public RegisterController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "/register")
	public String registerForm() {
		logger.info("register call");
		return "registerForm";
	}
	
	@RequestMapping(value = "/register/add", method = RequestMethod.POST)
	public String registerAdd(MemberDto member, Model m) {
		logger.info("member : " + member.toString());
		try {
			int row = memberService.write(member);
			if(row != 0) {
				MemberDto regiMember = memberService.read(member.getId());
				logger.info("regiMember : " + regiMember.toString());
				m.addAttribute("member", regiMember);
				return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
