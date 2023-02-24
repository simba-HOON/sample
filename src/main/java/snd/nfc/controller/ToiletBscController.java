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
import snd.nfc.model.GrsBscVO;
import snd.nfc.model.ToiletBscVO;
import snd.nfc.service.BscManageService;

@Controller
public class ToiletBscController {
		private static final Logger logger = LoggerFactory.getLogger(ToiletBscController.class);
		
		@Autowired
		BscManageService manageService;

		//화장실 기본 목록 페이지 진입
		@RequestMapping(value="/toiletBsc", method=RequestMethod.GET)
		public void toiletBscPageGet(BscCriteria cri, Model model) throws Exception {
			logger.info("화장실 기본 목록페이지 진입"+cri);
			System.out.println("화장실 기본 목록페이지 진입");
			
			//가로수 목록 출력 데이터
			List list = manageService.toiletBscGetList1(cri);
			model.addAttribute("list",list);
			
			//페이지 이동 인터페이스의 데이터들
			int total=manageService.toiletBscTotal(cri);
			BscPageDTO pageMaker = new BscPageDTO(cri, total);
			model.addAttribute("pageMaker", pageMaker);
		}	
		
		//화장실 상세  페이지
		@GetMapping(value="/toiletBscDetail")
		public void toiletBscGetDetail(String toilet_tag_id, BscCriteria cri, Model model) throws Exception {
			logger.info("화장실 상세페이지"+toilet_tag_id);
			
			model.addAttribute("toiletBscDetail", manageService.toiletBscGetDetail(toilet_tag_id));
			
		}
		
		//화장실 엑셀 
		@GetMapping(value="/toiletBscExcelDown")
		public void toiletBscGetExcel(@ModelAttribute("toiletBscVO") ToiletBscVO toiletBscVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
			
			manageService.toiletBscGetExcel(toiletBscVO, request, response);
		}
		
}