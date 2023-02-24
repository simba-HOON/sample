package snd.nfc.mapper;

import java.util.List;

import snd.nfc.model.BscCriteria;
import snd.nfc.model.GrsBscVO;
import snd.nfc.model.ParkBscVO;
import snd.nfc.model.ToiletBscVO;

public interface BscManageMapper {
	
	//가로수 기본 목록 총 갯수
	public int grsBscTotal(BscCriteria cri); 	
	//가로수 기본 정보 목록
	public List<GrsBscVO> grsBscGetList1(BscCriteria cri);
	//가로수 상세 정보 목록
	public GrsBscVO grsBscGetDetail(String grs_tag_id);
	//가로수 엑셀 다운로드
	public List<GrsBscVO> grsBscGetExcel(GrsBscVO grsBscVO);
	
	
	
	//공원 기본목록 총 갯수
	public int parkBscTotal(BscCriteria cri); 	
	//공원 기본 정보 목록
	public List<ParkBscVO> parkBscGetList1(BscCriteria cri);
	//공원 상세 정보 목록
	public ParkBscVO parkBscGetDetail(String park_tag_id);
	//공원 엑셀 다운로드
	public List<ParkBscVO> parkBscGetExcel(ParkBscVO parkBscVO);
	
	
	//화장실 기본목록 총 갯수
	public int toiletBscTotal(BscCriteria cri); 		
	//화장실 기본 정보 목록
	public List<ToiletBscVO> toiletBscGetList1(BscCriteria cri);
	//화장실 상세 정보목록
	public ToiletBscVO toiletBscGetDetail(String toilet_tag_id);
	//화장실 엑셀 다운로드
	public List<ToiletBscVO> toiletBscGetExcel(ToiletBscVO toiletBscVO);

}