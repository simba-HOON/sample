package snd.nfc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snd.nfc.model.ComplCriteria;
import snd.nfc.model.GrsBscVO;
import snd.nfc.model.GrsComplVO;
import snd.nfc.model.ParkComplVO;
import snd.nfc.model.ToiletComplVO;

public interface ComplManageService {

	//가로수 민원 목록 총 개수
	public int grsComplGetTotal(ComplCriteria complCriteria) throws Exception;
	//가로수 민원 목록 조회
	public List<GrsComplVO> grsComplGetList(ComplCriteria complCriteria) throws Exception;
	//가로수 민원 엑셀 다운로드
	public void grsComplGetExcel(GrsComplVO grsComplVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//가로수 민원 상세조회
	public GrsComplVO grsComplGetDetail(String compl_grs_tag_id) throws Exception;

	
	
	//공원 민원 목록 총 갯수
	public int parkComplGetTotal(ComplCriteria complCriteria) throws Exception;	
	//공원 민원 목록 조회
	public List<ParkComplVO> parkComplGetList(ComplCriteria complCriteria) throws Exception;
	//공원 민원 상세조회
	public ParkComplVO parkComplGetDetail(String compl_park_tag_id) throws Exception;
	//공원 민원 엑셀 다운로드
	public void parkComplGetExcel(ParkComplVO parkComplVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	

	//화장실 민원 목록 총 갯수
	public int toiletComplGetTotal(ComplCriteria complCriteria) throws Exception;	
	//화장실 민원 목록 조회
	public List<ToiletComplVO> toiletComplGetList(ComplCriteria complCriteria) throws Exception;
	//화장실 민원 상세
	public ToiletComplVO toiletComplGetDetail(String compl_toilet_tag_id) throws Exception;
	//화장실 민원 엑셀
	public void toiletComplGetExcel(ToiletComplVO toiletComplVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
		
}