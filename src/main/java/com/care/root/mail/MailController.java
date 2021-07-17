package com.care.root.mail;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
	@Autowired MailService ms;
	@GetMapping("sendmail")
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<htm><body>");
		sb.append("<h1>제품소개</h1>");
		sb.append("<a href='https://www.youtube.com/'>");
		sb.append("<img src='https://img.hani.co.kr/imgdb/resize/2008/1211/122889779786_20081211.JPG'>");
		sb.append("</a></body></html>");
		String str = sb.toString();
		ms.sendMail("yhk8148@naver.com", "테스트 메일(제목)", str);		
		
		out.print("메일을 보냈습니다.");
	}
	
	@GetMapping("auth_form")
	public String authForm() {
		return "authentication";
	}
	
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:https://mail.naver.com/";
	}
	
	@GetMapping("auth_check")
	public String auth_check(@RequestParam String userid, @RequestParam String userkey, HttpSession session) {
		String sessionkey = (String)session.getAttribute(userid);
		if(sessionkey != null) {
			if(sessionkey.equals(userkey)) {
				session.setAttribute("userid", userid);
			}
		}
		return "redirect:auth_form";
	}
}
