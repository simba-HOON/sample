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
import snd.nfc.service.BscManageService;

@Controller
public class GrsBscController {
		private static final Logger logger = LoggerFactory.getLogger(GrsBscController.class);
	
		@Autowired
		BscManageService manageService;
		
		//메인 페이지 진입		 	
		@RequestMapping(value="/main", method=RequestMethod.GET)
		public void mainPageGet() {
			logger.info("메인페이지 진입");
			System.out.println("메인페이지 진입");			
		}
		
		//임시 서브 메인페이지
		@RequestMapping
		public void submainPageGet() {
			logger.info("서브 메인페이지 진입");

		}
		
		//가로수 기본 목록 페이지 진입
		@RequestMapping(value="/grsBsc1", method=RequestMethod.GET)
		public void grsBscPageGet(BscCriteria cri, Model model) throws Exception {
			logger.info("가로수 기본 목록페이지 진입"+cri);
			System.out.println("가로수 기본 목록페이지 진입");
			
			//가로수 목록 출력 데이터
			List list = manageService.grsBscGetList1(cri);
			model.addAttribute("list",list);
			
			//페이지 이동 인터페이스의 데이터들
			int total=manageService.grsBscTotal(cri);
			BscPageDTO pageMaker = new BscPageDTO(cri, total);
			model.addAttribute("pageMaker", pageMaker);
		}
	

		//가로수 기본 상세 페이지 진입
		@GetMapping("/grsBscDetail")
		public void grsBscGetDetail(String grs_tag_id, BscCriteria cri, Model model) throws Exception {
			logger.info("상세페이지" + grs_tag_id);
			
			//상세페이지의 키값
			model.addAttribute("grsBscDetail", manageService.grsBscGetDetail(grs_tag_id));
		}
			
	
		
		//가로수 기본 엑셀데이터
		@GetMapping("/grsBscExcelDown")
		public void grsBscGetExcel(@ModelAttribute("grsBscVO") GrsBscVO grsBscVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
			manageService.grsBscGetExcel(grsBscVO, request, response);
			
		}
}
