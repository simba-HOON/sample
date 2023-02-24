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
import snd.nfc.model.ToiletComplVO;
import snd.nfc.service.ComplManageService;

@Controller
public class ToiletComplController {
	private static final Logger logger = LoggerFactory.getLogger(ToiletComplController.class);

	@Autowired
	ComplManageService complManageService;
	
	//화장실 민원 목록 페이지 진입
	@RequestMapping(value="/toiletCompl", method=RequestMethod.GET)
	public void toiletComplPageGet(ComplCriteria complCriteria, Model model) throws Exception {
		logger.info("화장실 민원 목록페이지 진입");
		System.out.println("화장실 민원 목록페이지 진입");
		
		//화장실 민원 출력 데이터
		List list2 = complManageService.toiletComplGetList(complCriteria);
		model.addAttribute("list2", list2);
		
		//페이지 이동 인터페이스의 데이터들
		int total2=complManageService.toiletComplGetTotal(complCriteria);
		ComplPageDTO pageMaker2 = new ComplPageDTO(complCriteria, total2);
		model.addAttribute("pageMaker2", pageMaker2);
	}

	//화장실 민원 상세
	@GetMapping(value="/toiletComplDetail")
	public void toiletComplGetDetail(String compl_toilet_tag_id, ComplCriteria cri, Model model) throws Exception {
		logger.info("화장실 민원 상세"+compl_toilet_tag_id);
		
		model.addAttribute("toiletComplDetail", complManageService.toiletComplGetDetail(compl_toilet_tag_id));
	}

	//화장실 민원 엑셀
	@GetMapping(value="/toiletComplExcelDown")
	public void toiletComplGetExcel(@ModelAttribute("toiletComplVO") ToiletComplVO toiletComplVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		complManageService.toiletComplGetExcel(toiletComplVO, request, response);
	}
}
