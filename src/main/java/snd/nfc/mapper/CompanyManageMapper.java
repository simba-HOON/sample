package snd.nfc.mapper;

import java.util.List;
import snd.nfc.model.CompanyCriteria;
import snd.nfc.model.GrsBscVO;
import snd.nfc.model.GrsCompanyVO;
import snd.nfc.model.ParkCompanyVO;
import snd.nfc.model.ToiletCompanyVO;

public interface CompanyManageMapper {

	
	//가로수 Company 총 개수
	public int grsCompanyGetTotal(CompanyCriteria companyCriteria);
	//가로수 Company 목록
	public List<GrsCompanyVO> grsCompanyGetList(CompanyCriteria companyCriteria);
	//가로수 업체 엑셀 다운로드
	public List<GrsCompanyVO> grsCompanyGetExcel(GrsCompanyVO grsCompanyVO);
	//가로수 업체 상세페이지
	public GrsCompanyVO grsCompanyGetDetail(String cor_reg_no);
	
	
	
	//공원 업체 총 갯수
	public int parkCompanyGetTotal(CompanyCriteria companyCriteria);
	//공원 업체 목록
	public List<ParkCompanyVO> parkCompanyGetList(CompanyCriteria companyCriteria);
	//공원 업체 상세페이지
	public ParkCompanyVO parkCompanyGetDetail(String cor_reg_no);
	//공원 업체 엑셀 다운로드
	public List<ParkCompanyVO> parkCompanyGetExcel(ParkCompanyVO parkCompanyVO);
	
	
	
	//화장실 업체 총 갯수
	public int toiletCompanyGetTotal(CompanyCriteria companyCriteria);
	//화장실 업체 목록
	public List<ToiletCompanyVO> toiletCompanyGetList(CompanyCriteria companyCriteria);
	//화장실 업체 상세페이지
	public ToiletCompanyVO toiletCompanyGetDetail(String cor_reg_no);
	//화장실 업체 엑셀 다운로드
	public List<ToiletCompanyVO> toiletCompanyGetExcel(ToiletCompanyVO toiletCompanyVO);
	
}
