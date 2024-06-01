package com.dbinfocompany.dbinfo.controller.member;

import javax.servlet.http.HttpSession;
import com.dbinfocompany.dbinfo.domain.member.MemberDto;
import com.dbinfocompany.dbinfo.service.member.MemberService;
import com.dbinfocompany.dbinfo.utility.SHA256;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	//의존성 생성자 주입
	private final MemberService memberService;
	
	@Autowired
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	/*
	 * 로그인 화면
	 */
	@RequestMapping(value = "")
    public String loginForm() {
        return "loginForm";
    }

    /*
     * 로그아웃
     */
	@RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }
    
    /*
     * 로그인
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String doaction(MemberDto member){
		String YorN = "No";
		
		try {
			String getpw = member.getPw();
			SHA256 sha256before = new SHA256(getpw);
			String sha256After = sha256before.changesha(); 
			
			MemberDto dbMember = memberService.read(member.getId());
			if(!dbMember.getPw().equals(sha256After)) {
				YorN ="No";
			}
			
			if (dbMember != null && dbMember.getAcept().equals("승인")) {
				YorN = "Yes";
			} else if (dbMember != null && dbMember.getAcept().equals("거절")) {
				YorN = "Acept";
			}
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("loginController : " + YorN);
		return YorN;
	}
}