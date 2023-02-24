package snd.nfc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import snd.nfc.model.CompanyCriteria;
import snd.nfc.model.CompanyPageDTO;
import snd.nfc.model.GrsCompanyVO;
import snd.nfc.model.ParkCompanyVO;
import snd.nfc.service.CompanyManegeService;

@Controller
public class ParkCompanyController {
	private static final Logger log = LoggerFactory.getLogger(ParkCompanyController.class);
	
	@Autowired
	CompanyManegeService companyManegeService;
	
	@RequestMapping(value="/parkCompany", method=RequestMethod.GET)
	public void companyManageGET(CompanyCriteria companyCriteria, Model model) throws Exception {
		log.info("공원 회사 목록 페이지 접근");
		System.out.println("공원 회사 목록 페이지 접근");
		
		//공원 회사 목록 출력 데이터
		List list3 = companyManegeService.parkCompanyGetList(companyCriteria);
		model.addAttribute("list3", list3);
		
		//페이지 이동 인터페이스 데이터
		int total3 = companyManegeService.parkCompanyGetTotal(companyCriteria);
		CompanyPageDTO pageMaker3=new CompanyPageDTO(companyCriteria, total3);
		model.addAttribute("pageMaker3", pageMaker3);
		
	}
	
	//공원 업체  상세
	@GetMapping(value="/parkCompanyDetail")
	public void parkCompanyGetDetail(String cor_reg_no, CompanyCriteria cri, Model model) throws Exception {
		log.info("공원 업체 상세페이지"+cor_reg_no);
		
		model.addAttribute("parkCompanyDetail", companyManegeService.parkCompanyGetDetail(cor_reg_no));
		
	}

	//공원 업체 엑셀다운
	@GetMapping(value="/parkCompanyExcelDown")	
	public void parkCompanyGetExcel(@ModelAttribute("parkCompanyVO") ParkCompanyVO parkCompanyVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
		companyManegeService.parkCompanyGetExcel(parkCompanyVO, request, response);
	}
}
