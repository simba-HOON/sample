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

import snd.nfc.model.BscCriteria;
import snd.nfc.model.BscPageDTO;
import snd.nfc.model.ParkBscVO;
import snd.nfc.service.BscManageService;

@Controller
public class ParkBscController {
	private static final Logger logger = LoggerFactory.getLogger(ParkBscController.class);

	@Autowired
	BscManageService manageService;
	
	//공원 기본 목록 페이지 진입
	@RequestMapping(value="/parkBsc", method=RequestMethod.GET)
	public void parkBscPageGet(BscCriteria cri, Model model) throws Exception {
		logger.info("공원 기본 목록페이지 진입"+cri);
		System.out.println("공원 기본 목록페이지 진입");
		
		//공원 목록 출력데이터
		List list = manageService.parkBscGetList1(cri);
		model.addAttribute("list", list);
		
		//페이지 이동 인터페이스 데이터들
		int total=manageService.parkBscTotal(cri);
		BscPageDTO pageMaker = new BscPageDTO(cri, total);
		model.addAttribute("pageMaker", pageMaker);	
	}
	
	//공원 상세 페이지
	@GetMapping(value="/parkBscDetail")
	public void parkBscGetDetail(String park_tag_id, BscCriteria cri, Model model) throws Exception {
		logger.info("공원 상세페이지" +park_tag_id);
		
		model.addAttribute("parkBscDetail", manageService.parkBscGetDetail(park_tag_id));
		
	}
	
	
	//공원 엑셀 
	@GetMapping(value="/parkBscExcelDown")
	public void parkBscGetExcel(@ModelAttribute("parkBscVO") ParkBscVO parkBscVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
		manageService.parkBscGetExcel(parkBscVO, request, response);
	}
	
}

