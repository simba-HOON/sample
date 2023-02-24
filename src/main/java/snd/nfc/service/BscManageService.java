package snd.nfc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snd.nfc.model.BscCriteria;
import snd.nfc.model.GrsBscVO;
import snd.nfc.model.ParkBscVO;
import snd.nfc.model.ToiletBscVO;

public interface BscManageService {
	
	
	//가로수 기본 목록 총 갯수
	public int grsBscTotal(BscCriteria cri) throws Exception;	
	//가로수 기본 목록 조회
	public List<GrsBscVO> grsBscGetList1(BscCriteria cri) throws Exception;
	//가로수 상세정보 조회
	public GrsBscVO grsBscGetDetail(String grs_tag_id) throws Exception;
	//가로수 엑셀 다운로드
	public void grsBscGetExcel(GrsBscVO grsBscVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	
	//공원 기본 목록 총 갯수
	public int parkBscTotal(BscCriteria cri) throws Exception;
	//공원 기본 목록 조회
	public List<ParkBscVO> parkBscGetList1(BscCriteria cri) throws Exception;
	//공원 상세정보조회
	public ParkBscVO parkBscGetDetail(String park_tag_id) throws Exception;
	//공원 엑셀 다운로드
	public void parkBscGetExcel(ParkBscVO parkBscVO, HttpServletRequest request, HttpServletResponse response) throws Exception;	

	
	
	//화장실 기본 목록 총 갯수
	public int toiletBscTotal(BscCriteria cri) throws Exception;
	//화장실 기본 목록 조회
	public List<ToiletBscVO> toiletBscGetList1(BscCriteria cri) throws Exception;
	//화장실 상세정보
	public ToiletBscVO toiletBscGetDetail(String toilet_tag_id) throws Exception;
	//화장실 엑셀 다운로드
	public void toiletBscGetExcel(ToiletBscVO toiletBscVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}