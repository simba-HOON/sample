package snd.nfc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import snd.nfc.model.MngVO;

public class MainInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(MainInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("MainInterceptor의 preHandler진입");
		
		System.out.println("MainInterceptor의 preHandler진입");
		
		//세션 값 불러오기
		HttpSession session = request.getSession();
		
		// 불러온  세션 값에서 manage찾기
		MngVO lvo = (MngVO)session.getAttribute("manager_yn");
		
		if (lvo==null || lvo.getManager_yn()!="1") {		//manager_yn=1 이 아닌경우
			response.sendRedirect("/");						//리다이렉트 home
			return false;
		}
				
		return true;
	}
	
}
