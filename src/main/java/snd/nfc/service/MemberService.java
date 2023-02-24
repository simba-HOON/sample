package snd.nfc.service;

import snd.nfc.model.MngVO;

public interface MemberService {

	//관리자 가입
	public void memberJoin(MngVO mngVO) throws Exception;
	
	//로그인
	public MngVO memberLogin(MngVO mngVO) throws Exception;
	
	
}
