package snd.nfc.mapper;

import snd.nfc.model.MngVO;

public interface MemberMapper {

	//회원가입 맵퍼
	public void memberJoin(MngVO mngVO);
	
	
	//로그인 맵퍼
	public MngVO memberLogin(MngVO mngVO);
	
	
}
