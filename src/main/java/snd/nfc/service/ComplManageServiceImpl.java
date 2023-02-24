package snd.nfc.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snd.nfc.mapper.ComplManageMapper;
import snd.nfc.model.ComplCriteria;
import snd.nfc.model.GrsComplVO;
import snd.nfc.model.ParkComplVO;
import snd.nfc.model.ToiletComplVO;

@Service
public class ComplManageServiceImpl implements ComplManageService {
	private static final Logger logger = LoggerFactory.getLogger(ComplManageServiceImpl.class);
	
	@Autowired
	ComplManageMapper complManageMapper;
	
	//가로수 민원 목록 총 개수
	@Override
	public int grsComplGetTotal(ComplCriteria complCriteria) throws Exception {
		logger.info("가로수 민원 총 갯수 Impl 진입 (내용) = " +complCriteria);
		
		return complManageMapper.grsComplGetTotal(complCriteria);
	}	
	//가로수 민원 목록
	@Override
	public List<GrsComplVO> grsComplGetList(ComplCriteria complCriteria) throws Exception {
		logger.info("가로수 민원목록 Impl 진입 (내용) = " + complCriteria);
		
		return complManageMapper.grsComplGetList(complCriteria);
	}
	
	//가로수 민원 상세
	@Override
	public GrsComplVO grsComplGetDetail(String compl_grs_tag_id) throws Exception {
		logger.info("가로수 민원 상세페이지"+compl_grs_tag_id);
		
		return complManageMapper.grsComplGetDetail(compl_grs_tag_id);
	}
	
	//가로수 민원 엑셀다운로드
	private void setHeaderCS(CellStyle cs, Font font, Cell cell) {
		  cs.setAlignment(CellStyle.ALIGN_CENTER);
		  cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		  cs.setBorderTop(CellStyle.BORDER_THIN);
		  cs.setBorderBottom(CellStyle.BORDER_THIN);
		  cs.setBorderLeft(CellStyle.BORDER_THIN);
		  cs.setBorderRight(CellStyle.BORDER_THIN);
		  cs.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
		  cs.setFillPattern(CellStyle.SOLID_FOREGROUND);
		  setHeaderFont(font, cell);
		  cs.setFont(font);
		  cell.setCellStyle(cs);
		}
		 
	private void setHeaderFont(Font font, Cell cell) {
		  font.setBoldweight((short) 700);
		  font.setColor(HSSFColor.WHITE.index);
		}
		 
	private void setCmmnCS2(CellStyle cs, Cell cell) {
		  cs.setAlignment(CellStyle.ALIGN_LEFT);
		  cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		  cs.setBorderTop(CellStyle.BORDER_THIN);
		  cs.setBorderBottom(CellStyle.BORDER_THIN);
		  cs.setBorderLeft(CellStyle.BORDER_THIN);
		  cs.setBorderRight(CellStyle.BORDER_THIN);
		  cell.setCellStyle(cs);
		}
	
	@Override
	public void grsComplGetExcel(GrsComplVO grsComplVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<GrsComplVO> list = complManageMapper.grsComplGetExcel(grsComplVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 25000);
		sheet.setColumnWidth((short) 3, (short) 5000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("가로수 민원 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));

		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("민원 발생 가로수");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("민원 카테고리");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("민원 내용");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("민원인 이름");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("민원 처리 상태");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("민원 등록 일자");
		setHeaderCS(cs, font, cell);
		
		int i = 2;
		
		for (GrsComplVO vo : list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String complCreateDate = sdf.format(vo.getComplt_compl_cr_dt());
			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
			
			cell=row.createCell(0);
			cell.setCellValue(vo.getCompl_grs_tag_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getCompl_category());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getCompl_content());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getComplt_name());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getCompl_state());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(complCreateDate);
			setCmmnCS2(cs, cell);
			
			i++;
		}
		
		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"GrsComplaintList.xlsx\""));
		wb.write(response.getOutputStream());
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//공원 민원 목록 총 갯수
	@Override
	public int parkComplGetTotal(ComplCriteria complCriteria) throws Exception {
		logger.info("공원 민원 총 갯수 Impl 진입 (내용) = " +complCriteria);
		
		return complManageMapper.parkComplGetTotal(complCriteria);
	}
	
	//공원 민원목록
	@Override
	public List<ParkComplVO> parkComplGetList(ComplCriteria complCriteria) throws Exception {
		logger.info("공원 민원목록 Impl 진입 (내용) = " + complCriteria);
		
		return complManageMapper.parkComplGetList(complCriteria);
	}

	//공원 민원 상세페이지
	@Override
	public ParkComplVO parkComplGetDetail(String compl_park_tag_id) throws Exception {
		logger.info("공원 민원 상세 목록 Impl 진입 (내용) = " + compl_park_tag_id);
		
		return complManageMapper.parkComplGetDetail(compl_park_tag_id);
	}

	//공원 민원 엑셀
	@Override
	public void parkComplGetExcel(ParkComplVO parkComplVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<ParkComplVO> list = complManageMapper.parkComplGetExcel(parkComplVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 25000);
		sheet.setColumnWidth((short) 3, (short) 5000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("공원 민원 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));

		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("민원 발생 공원 아이디");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("민원 카테고리");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("민원 내용");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("민원인 이름");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("민원 연락처");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("민원 등록 일자");
		setHeaderCS(cs, font, cell);
		
		int i = 2;
		
		for (ParkComplVO vo : list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String complCreateDate = sdf.format(vo.getComplt_compl_cr_dt());
			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
			
			cell=row.createCell(0);
			cell.setCellValue(vo.getCompl_park_tag_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getCompl_category());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getCompl_content());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getComplt_name());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getComplt_phone());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(complCreateDate);
			setCmmnCS2(cs, cell);
			
			i++;
		}
		
		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"ParkComplaintList.xlsx\""));
		wb.write(response.getOutputStream());
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//화장실 민원 목록 총 갯수
	@Override
	public int toiletComplGetTotal(ComplCriteria complCriteria) throws Exception {
		logger.info("화장실 민원 총 갯수 Impl 진입 (내용) = " +complCriteria);
		
		return complManageMapper.toiletComplGetTotal(complCriteria);
	}
	//화장실 민원목록
	@Override
	public List<ToiletComplVO> toiletComplGetList(ComplCriteria complCriteria) throws Exception {
		logger.info("화장실 민원목록 Impl 진입 (내용) = " + complCriteria);
		
		return complManageMapper.toiletComplGetList(complCriteria);
	}
	//화장실 민원 상세
	@Override
	public ToiletComplVO toiletComplGetDetail(String compl_toilet_tag_id) throws Exception {
		logger.info("화장실 민원상세"+compl_toilet_tag_id);
		
		return complManageMapper.toiletComplGetDetail(compl_toilet_tag_id);
	}
	
	//화장실 민원 엑셀
	@Override
	public void toiletComplGetExcel(ToiletComplVO toiletComplVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<ToiletComplVO> list = complManageMapper.toiletComplGetExcel(toiletComplVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 25000);
		sheet.setColumnWidth((short) 3, (short) 5000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("화장실 민원 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));

		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("민원 발생 화장실 아이디");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("민원 카테고리");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("민원 내용");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("민원인 이름");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("민원 연락처");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("민원 등록 일자");
		setHeaderCS(cs, font, cell);
		
		int i = 2;
		
		for (ToiletComplVO vo : list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String complCreateDate = sdf.format(vo.getComplt_compl_cr_dt());
			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
			
			cell=row.createCell(0);
			cell.setCellValue(vo.getCompl_toilet_tag_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getCompl_category());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getCompl_content());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getComplt_name());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getComplt_phone());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(complCreateDate);
			setCmmnCS2(cs, cell);
			
			i++;
		}
		
		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"ToiletComplaintList.xlsx\""));
		wb.write(response.getOutputStream());		
	}

}