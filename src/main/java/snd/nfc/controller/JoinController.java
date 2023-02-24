package snd.nfc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import snd.nfc.model.MngVO;
import snd.nfc.service.MemberService;

@Controller
public class JoinController {
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	//관리자 가입 페이지로 이동
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void joinGET() {
		logger.info("관리자 추가 페이지 진입");
		System.out.println("관리자 추가 페이지");
	}
	
	//관리자 가입 페이지 안에서 발생되는 POST 액션
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(MngVO mngVO) throws Exception {
		logger.info("joinPost 진입");
		
		//패스워드 인코딩
		String rawPw = "";
		String encodePw = "";
		//raw - encoding - encoded - mng_password
		rawPw = mngVO.getMng_password();
		encodePw = pwEncoder.encode(rawPw);
		mngVO.setMng_password(encodePw);
		
		memberservice.memberJoin(mngVO);
		logger.info("joinPost 완료");
		return "redirect:/";
	}
	
}
