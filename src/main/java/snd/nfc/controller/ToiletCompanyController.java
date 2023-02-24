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
import snd.nfc.model.ToiletCompanyVO;
import snd.nfc.service.CompanyManegeService;

@Controller
public class ToiletCompanyController {
	private static final Logger log = LoggerFactory.getLogger(ToiletCompanyController.class);
	
	@Autowired
	//e 오타, 추후 변경하면 좋을듯
	CompanyManegeService companyManegeService;
	
	@RequestMapping(value="/toiletCompany", method=RequestMethod.GET)
	public void companyManageGET(CompanyCriteria companyCriteria, Model model) throws Exception {
		log.info("화장실 회사 목록 페이지 접근");
		System.out.println("화장실 회사 목록 페이지 접근");
		
		//화장실 회사 목록 출력 데이터
		List list3 = companyManegeService.toiletCompanyGetList(companyCriteria);
		model.addAttribute("list3", list3);
		
		//페이지 이동 인터페이스 데이터
		int total3 = companyManegeService.toiletCompanyGetTotal(companyCriteria);
		CompanyPageDTO pageMaker3=new CompanyPageDTO(companyCriteria, total3);
		model.addAttribute("pageMaker3", pageMaker3);
		
	}
	
	//업체 상세 페이지
	@GetMapping(value="/toiletCompanyDetail")
	public void toiletCompanyGetDetail (String cor_reg_no, CompanyCriteria cri, Model model) throws Exception {
		log.info("화장실 상세 페이지"+cor_reg_no);
		
		model.addAttribute("toiletCompanyDetail", companyManegeService.toiletCompanyGetDetail(cor_reg_no));
		}
	
	//업체 엑셀 다운
	@GetMapping(value="/toiletCompanyExcelDown")
	public void toiletCompanyGetExcel(@ModelAttribute("toiletCompanyVO") ToiletCompanyVO toiletCompanyVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
		companyManegeService.toiletCompanyGetExcel(toiletCompanyVO, request, response);
	}
	
}