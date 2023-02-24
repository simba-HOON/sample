package snd.nfc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snd.nfc.model.CompanyCriteria;
import snd.nfc.model.GrsBscVO;
import snd.nfc.model.GrsCompanyVO;
import snd.nfc.model.ParkCompanyVO;
import snd.nfc.model.ToiletCompanyVO;

public interface CompanyManegeService {
	
	//가로수 회사 목록
	public List<GrsCompanyVO> grsCompanyGetList(CompanyCriteria companyCriteria) throws Exception;	
	//가로수 company 총 개수
	public int grsCompanyGetTotal(CompanyCriteria companyCriteria) throws Exception;
	//가로수 회사 엑셀 다운로드
	public void grsCompanyGetExcel(GrsCompanyVO grsCompanyVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//가로수 회사 상세 페이지
	public GrsCompanyVO grsCompanyGetDetail(String cor_reg_no) throws Exception;

	
	
	
	//공원 회사 목록
	public List<ParkCompanyVO> parkCompanyGetList(CompanyCriteria companyCriteria) throws Exception;	
	//공원 company 총 개수
	public int parkCompanyGetTotal(CompanyCriteria companyCriteria) throws Exception;	
	//공원 회사 상세
	public ParkCompanyVO parkCompanyGetDetail(String cor_reg_no) throws Exception;
	//공원 회사 엑셀 다운로드
	public void parkCompanyGetExcel(ParkCompanyVO parkCompanyVO, HttpServletRequest request, HttpServletResponse response) throws Exception;

	
	
	
	//화장실 회사 목록
	public List<ToiletCompanyVO> toiletCompanyGetList(CompanyCriteria companyCriteria) throws Exception;	
	//화장실 company 총 개수
	public int toiletCompanyGetTotal(CompanyCriteria companyCriteria) throws Exception;	
	//화장실 상세페이지
	public ToiletCompanyVO toiletCompanyGetDetail(String cor_reg_no) throws Exception;
	//화장실 회사 엑셀
	public void toiletCompanyGetExcel(ToiletCompanyVO toiletCompanyVO, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
