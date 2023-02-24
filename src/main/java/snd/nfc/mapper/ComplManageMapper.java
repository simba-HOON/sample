package snd.nfc.mapper;

import java.util.List;

import snd.nfc.model.ComplCriteria;
import snd.nfc.model.GrsComplVO;
import snd.nfc.model.ParkComplVO;
import snd.nfc.model.ToiletComplVO;

public interface ComplManageMapper {
	

	//가로수 민원 목록 총 개수
	public int grsComplGetTotal(ComplCriteria complCriteria);
	//가로수 민원 목록
	public List <GrsComplVO> grsComplGetList(ComplCriteria complCriteria);
	//가로수 민원 엑셀 다운로드
	public List<GrsComplVO> grsComplGetExcel(GrsComplVO grsComplVO);
	//가로수 민원 상세정보
	public GrsComplVO grsComplGetDetail(String compl_grs_tag_id);
	
	
	
	//공원 민원 목록 총 갯수
	public int parkComplGetTotal(ComplCriteria complCriteria);
	//공원 민원 목록
	public List <ParkComplVO> parkComplGetList(ComplCriteria complCriteria);
	//공원 민원 상세정보
	public ParkComplVO parkComplGetDetail(String compl_park_tag_id);
	//공원 민원 엑셀
	public List<ParkComplVO> parkComplGetExcel(ParkComplVO parkComplVO);
	
	
	
	//화장실 민원 목록 총 갯수
	public int toiletComplGetTotal(ComplCriteria complCriteria);
	//화장실 민원 목록
	public List <ToiletComplVO> toiletComplGetList(ComplCriteria complCriteria);
	//화장실 민원 상세
	public ToiletComplVO toiletComplGetDetail(String compl_toilet_tag_id);
	//화장실 민원 엑셀
	public List<ToiletComplVO> toiletComplGetExcel(ToiletComplVO toiletComplVO);
	
}