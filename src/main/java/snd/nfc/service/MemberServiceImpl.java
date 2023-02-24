package snd.nfc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snd.nfc.mapper.MemberMapper;
import snd.nfc.model.MngVO;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(BscManageServiceImpl.class);

	@Autowired
	MemberMapper membermapper;

	@Override
	public void memberJoin(MngVO mngVO) throws Exception {
		logger.info("멤버 서비스, 멤버 조인 Impl 진입");
		membermapper.memberJoin(mngVO);
	}

	@Override
	public MngVO memberLogin(MngVO mngVO) throws Exception {
		logger.info("멤버 서비스, 멤버 로그인 Imple 진입");
		return membermapper.memberLogin(mngVO);
	}

}
