package snd.nfc.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snd.nfc.mapper.BscManageMapper;
import snd.nfc.model.BscCriteria;
import snd.nfc.model.GrsBscVO;
import snd.nfc.model.ParkBscVO;
import snd.nfc.model.ToiletBscVO;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


@Service
public class BscManageServiceImpl implements BscManageService {
	private static final Logger logger = LoggerFactory.getLogger(BscManageServiceImpl.class);
	
	@Autowired
	BscManageMapper managemapper;
	
	//가로수 bsc_info 총 갯수
	@Override
	public int grsBscTotal(BscCriteria cri) throws Exception {
		logger.info("가로수 기본 총 갯수 Impl 진입 (내용) = " +cri);
		
		return managemapper.grsBscTotal(cri);
	}	
	//가로수 기본 목록
	@Override
	public List<GrsBscVO> grsBscGetList1(BscCriteria cri) throws Exception {
		logger.info("가로수 목록 Impl 진입 (내용) = " +cri);
		
		return managemapper.grsBscGetList1(cri);
	}
	//가로수 상세페이지
	@Override
	public GrsBscVO grsBscGetDetail(String grs_tag_id) throws Exception {
		logger.info("가로수 상세페이지 진입" +grs_tag_id);
		
		return managemapper.grsBscGetDetail(grs_tag_id);
	}
	
	
	//가로수 기본 엑셀다운로드
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
	public void grsBscGetExcel(GrsBscVO grsBscVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<GrsBscVO> list = managemapper.grsBscGetExcel(grsBscVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 5000);
		sheet.setColumnWidth((short) 3, (short) 5000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("가로수 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));
		
		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("태그 번호");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("가로수 이름");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("시행처");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("작업 회사");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("기본정보 생성일자");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("기본정보 최근 수정일");
		setHeaderCS(cs, font, cell);
		
		int i = 2;
		for (GrsBscVO vo : list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String creatDate = sdf.format(vo.getBsc_info_cr_dt());
			String updateDate = sdf.format(vo.getBsc_info_ud_dt());
			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
			
			cell=row.createCell(0);
			cell.setCellValue(vo.getGrs_tag_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getGrs_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getImpl_cp_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getWk_cp_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(creatDate);
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(updateDate);
			setCmmnCS2(cs, cell);
			
			i++;
			
		}
		
		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"GrsBscList.xlsx\""));
		wb.write(response.getOutputStream());
			
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//공원 기본정보 총 갯수
	@Override
	public int parkBscTotal(BscCriteria cri) throws Exception {
		logger.info("공원 기본 총 갯수 Impl 진입 (내용) = " +cri);
		
		return managemapper.parkBscTotal(cri);
	}
	
	//공원 기본정보 목록
	@Override
	public List<ParkBscVO> parkBscGetList1(BscCriteria cri) throws Exception {
		logger.info("공원 목록 Impl 진입 (내용) = " +cri);
		
		return managemapper.parkBscGetList1(cri);
	}
	
	//공원 상세정보
	@Override
	public ParkBscVO parkBscGetDetail(String park_tag_id) throws Exception {
		logger.info("공원 상세목록"+park_tag_id);
		
		return managemapper.parkBscGetDetail(park_tag_id);
	}
	
	//공원 기본 엑셀 다운
	@Override
	public void parkBscGetExcel(ParkBscVO parkBscVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<ParkBscVO> list = managemapper.parkBscGetExcel(parkBscVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 5000);
		sheet.setColumnWidth((short) 3, (short) 5000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("공원 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));
		
		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("공원 태그 번호");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("공원 이름");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("시행처");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("작업 회사");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("작업자");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("기본정보 생성일자");
		setHeaderCS(cs, font, cell);
		
		int i = 2;
		for (ParkBscVO vo : list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String creatDate = sdf.format(vo.getPark_bsc_info_cr_dt());

			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
			
			cell=row.createCell(0);
			cell.setCellValue(vo.getPark_tag_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getPark_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getPark_owner());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getPark_impl_cp_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getPark_wk_cp_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(creatDate);
			setCmmnCS2(cs, cell);
			
			i++;
			
		}
		
		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"ParkBscList.xlsx\""));
		wb.write(response.getOutputStream());
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//화장실 기본정보 총 갯수
	@Override
	public int toiletBscTotal(BscCriteria cri) throws Exception {
		logger.info("화장실 기본 총 갯수 Impl 진입 (내용) = " +cri);
		
		return managemapper.toiletBscTotal(cri);
	}
	
	//화장실 기본정보 목록
	@Override
	public List<ToiletBscVO> toiletBscGetList1(BscCriteria cri) throws Exception {
		logger.info("화장실 목록 Impl 진입 (내용) = " +cri);
		
		return managemapper.toiletBscGetList1(cri);
	}
	
	//화장실 상세페이지
	@Override
	public ToiletBscVO toiletBscGetDetail(String toilet_tag_id) throws Exception {
		logger.info("화장실 상세페이지"+toilet_tag_id);
		
		return managemapper.toiletBscGetDetail(toilet_tag_id);
	}
	
	//화장실 기본 엑셀 다운로드
	@Override
	public void toiletBscGetExcel(ToiletBscVO toiletBscVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<ToiletBscVO> list = managemapper.toiletBscGetExcel(toiletBscVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 5000);
		sheet.setColumnWidth((short) 3, (short) 5000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("화장실 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));
		
		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("화장실 아이디");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("화장실 이름");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("시행처");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("작업 회사");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("작업자");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("기본정보 생성일자");
		setHeaderCS(cs, font, cell);
		
		int i = 2;
		for (ToiletBscVO vo : list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String creatDate = sdf.format(vo.getToilet_bsc_info_cr_dt());

			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
			
			cell=row.createCell(0);
			cell.setCellValue(vo.getToilet_tag_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getToilet_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getToilet_owner());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getToilet_impl_cp_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getToilet_wk_cp_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(creatDate);
			setCmmnCS2(cs, cell);
			
			i++;
			
		}
		
		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"ToiletBscList.xlsx\""));
		wb.write(response.getOutputStream());		
	}

}
