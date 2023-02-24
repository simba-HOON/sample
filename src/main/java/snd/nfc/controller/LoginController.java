package snd.nfc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import snd.nfc.model.MngVO;
import snd.nfc.service.MemberService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	
	//로그인 페이지로 GET 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
		logger.info("로그인 GET 메소드 진입");
		System.out.println("로그인 페이지");
	}
	
	//로그인 버튼 클릭 수 POST 메소드 활성화
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MngVO mngVO, RedirectAttributes rttr) throws Exception {
		
		logger.info("로그인 POST 메소드 진입");
		
		//세션 초기화 후, 비번을 저장하기위함
		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";
		
		MngVO lvo = memberService.memberLogin(mngVO);
		
		//일치하는 아이디 존재
		if (lvo != null) {
			rawPw = mngVO.getMng_password();					//사용자 제출 비번
			encodePw = lvo.getMng_password();					//인코딩 된 비번
			if (true==pwEncoder.matches(rawPw, encodePw)) {		//비밀번호 일치여부 판단
				lvo.setMng_password("");						//인코딩 된 비밀번호 정보를 지움
				session.setAttribute("mngVO", lvo);				//세션에 사용자 정보 저장
				return "redirect:/main";
			} else {
				rttr.addFlashAttribute("result",0);				//비밀번호 불일치로 result = 0 
				return "redirect:/login";
			}						
		//일치하는 아이디가 비존재 (로그인 실패)
		} else {
			rttr.addFlashAttribute("result",0);					//아이디 불일치로 result = 0 
			return "redirect:/login";
		}			
	}
	
	
	
	
	
	//로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	
	public String logoutGET(HttpServletRequest request) throws Exception {
		logger.info("로그아웃 GET 메소드 진입");
		
		//세션 초기화
		HttpSession session = request.getSession();
		//invalidate로 전체 세션 삭제 (attribute remove와는 다름)
		session.invalidate();
	
		return "redirect:/";
	}

	//비동기 로그아웃
	@RequestMapping(value="/logout.do", method=RequestMethod.POST)
	@ResponseBody
	public void logoutPOST(HttpServletRequest request) throws Exception {
		logger.info("비동기 로그아웃 POST 메소드 진입");
		
		//세션 초기화
		HttpSession session = request.getSession();
		//invalidate로 전체 세션 삭제 (attribute remove와는 다름)
		session.invalidate();
		
	}
}
