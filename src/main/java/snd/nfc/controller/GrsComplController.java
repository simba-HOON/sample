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
import snd.nfc.model.ComplCriteria;
import snd.nfc.model.ComplPageDTO;
import snd.nfc.model.GrsComplVO;
import snd.nfc.service.ComplManageService;

@Controller
public class GrsComplController {
	private static final Logger logger = LoggerFactory.getLogger(GrsComplController.class);
	
	@Autowired
	ComplManageService complManageService;
	
	//가로수 민원 목록 페이지 진입
	@RequestMapping(value="/grsCompl", method=RequestMethod.GET)
	public void grsComplPageGet(ComplCriteria complCriteria, Model model) throws Exception {
		logger.info("가로수 민원 목록페이지 진입");
		System.out.println("가로수 민원 목록페이지 진입");
		
		//가로수 민원 출력 데이터
		List list2 = complManageService.grsComplGetList(complCriteria);
		model.addAttribute("list2", list2);
		
		//페이지 이동 인터페이스의 데이터들
		int total2=complManageService.grsComplGetTotal(complCriteria);
		ComplPageDTO pageMaker2 = new ComplPageDTO(complCriteria, total2);
		model.addAttribute("pageMaker2", pageMaker2);
	}
	
	
	//가로수 민원 상세 페이지 진입
	@GetMapping("/grsComplDetail")
	public void grsComplGetDetail(String compl_grs_tag_id, ComplCriteria cri, Model model) throws Exception {
		logger.info("민원 상세페이지" + compl_grs_tag_id);
		
		//상세페이지의 키값
		model.addAttribute("grsComplDetail", complManageService.grsComplGetDetail(compl_grs_tag_id));
	}
		
	
	//가로수 민원 엑셀 데이터
	@GetMapping("/grsComplExcelDown")
	public void grsComplGetExcel(@ModelAttribute("grsComplVO") GrsComplVO grsComplVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
	
		complManageService.grsComplGetExcel(grsComplVO, request, response);
		
	}

}