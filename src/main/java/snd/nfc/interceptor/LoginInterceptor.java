package snd.nfc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

//세션이 제거되지 않아 로그인을 위해  새로운 세션을 저장할 때 발생할 수 있는 에러를 방지하기위해 미리 세션을 제거
public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("LoginInterceptor의 preHandler 동작");
		System.out.println("LoginInterceptor의 preHandler 진입");		
		
		//session을 불러와서 초기화
		HttpSession session = request.getSession();
		session.invalidate();
		
		return true;
	}
	
}
