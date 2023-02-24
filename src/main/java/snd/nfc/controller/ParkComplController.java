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

import snd.nfc.model.ComplCriteria;
import snd.nfc.model.ComplPageDTO;
import snd.nfc.model.ParkComplVO;
import snd.nfc.service.ComplManageService;

@Controller
public class ParkComplController {
	private static final Logger logger = LoggerFactory.getLogger(ParkComplController.class);

	@Autowired
	ComplManageService complManageService;
	
	//공원 민원 목록 페이지 진입
	@RequestMapping(value="/parkCompl", method=RequestMethod.GET)
	public void parkComplPageGet(ComplCriteria complCriteria, Model model) throws Exception {
		logger.info("공원 민원 목록페이지 진입");
		System.out.println("공원 민원 목록페이지 진입");
		
		//공원 민원 출력 데이터
		List list2 = complManageService.parkComplGetList(complCriteria);
		model.addAttribute("list2", list2);
		
		//페이지 이동 인터페이스의 데이터들
		int total2=complManageService.parkComplGetTotal(complCriteria);
		ComplPageDTO pageMaker2 = new ComplPageDTO(complCriteria, total2);
		model.addAttribute("pageMaker2", pageMaker2);
	}
	
	//공원 상세페이지 
	@GetMapping(value="/parkComplDetail")
	public void parkComplGetDetail(String compl_park_tag_id, ComplCriteria cri, Model model) throws Exception {
		logger.info("공원 민원  상세페이지"+compl_park_tag_id);
		
		model.addAttribute("parkComplDetail", complManageService.parkComplGetDetail(compl_park_tag_id));
	}	
	
	//공원 민원 엑셀
	@GetMapping(value="/parkComplExcelDown")
	public void parkComplGetExcel(@ModelAttribute("parkComplVO") ParkComplVO parkComplVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
		complManageService.parkComplGetExcel(parkComplVO, request, response);
	}
	
}
