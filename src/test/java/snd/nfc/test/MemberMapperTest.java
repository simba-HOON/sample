package snd.nfc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import snd.nfc.mapper.MemberMapper;
import snd.nfc.model.MngVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoin() throws Exception {
		MngVO mngVO = new MngVO();
		
		mngVO.setMng_name("test1");
		mngVO.setMng_phone("01054578787");
		mngVO.setMng_uuid("sadfunewhi12kdsnf");
		mngVO.setMng_token("dsbnfiuqhiufinasdifn");
		mngVO.setMng_grade("1");
		mngVO.setMng_use_yn("1");
		mngVO.setManager_yn("1");
		
		memberMapper.memberJoin(mngVO);
		
	}
}
