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

import snd.nfc.mapper.CompanyManageMapper;
import snd.nfc.model.CompanyCriteria;
import snd.nfc.model.GrsCompanyVO;
import snd.nfc.model.ParkCompanyVO;
import snd.nfc.model.ToiletCompanyVO;

@Service
public class CompanyManageServiceImpl implements CompanyManegeService{
	private static final Logger log = LoggerFactory.getLogger(CompanyManageServiceImpl.class);
	
	@Autowired
	CompanyManageMapper companyManageMapper;

	//엑셀 공용
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
		
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//가로수 회사 목록
	@Override
	public List<GrsCompanyVO> grsCompanyGetList(CompanyCriteria companyCriteria) throws Exception {
		log.info("(service.grsCompanyGetList().."+companyCriteria);
		
		return companyManageMapper.grsCompanyGetList(companyCriteria);
	}

	//가로수 company 총 개수
	@Override
	public int grsCompanyGetTotal(CompanyCriteria companyCriteria) throws Exception {
		log.info("(service.grsCompanyGetTotal().."+companyCriteria);
		
		return companyManageMapper.grsCompanyGetTotal(companyCriteria);
	}
	//가로수 회사 상세페이지
	@Override
	public GrsCompanyVO grsCompanyGetDetail(String cor_reg_no) throws Exception {
		log.info("가로수 상세페이지 진입" +cor_reg_no);
		
		return companyManageMapper.grsCompanyGetDetail(cor_reg_no);
	}	
	
	//가로수 회사 엑셀 다운로드
	@Override
	public void grsCompanyGetExcel(GrsCompanyVO grsCompanyVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<GrsCompanyVO> list = companyManageMapper.grsCompanyGetExcel(grsCompanyVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 5000);
		sheet.setColumnWidth((short) 3, (short) 15000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("가로수 업체 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));
		
		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("사업자 번호");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("업체 명");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("업체 대표자");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("업체 주소");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("업체 아이디");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("업체 등록일자");
		setHeaderCS(cs, font, cell);	
		
		int i = 2;

		for(GrsCompanyVO vo :list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String companyCreteDate = sdf.format(vo.getSys_cr_dt());
			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
	
			cell=row.createCell(0);
			cell.setCellValue(vo.getCor_reg_no());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getCompany_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getPresident_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getCompany_addr());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getCompany_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(companyCreteDate);
			setCmmnCS2(cs, cell);
			
			i++;
			
		}

		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"GrsCompanyList.xlsx\""));
		wb.write(response.getOutputStream());
		
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//공원 업체 목록
	@Override
	public List<ParkCompanyVO> parkCompanyGetList(CompanyCriteria companyCriteria) throws Exception {
		log.info("(service.parkCompanyGetList().."+companyCriteria);
		
		return companyManageMapper.parkCompanyGetList(companyCriteria);
	}

	//공원 업체 총 갯수
	@Override
	public int parkCompanyGetTotal(CompanyCriteria companyCriteria) throws Exception {
		log.info("(service.parkCompanyGetTotal().."+companyCriteria);
		    
		return companyManageMapper.parkCompanyGetTotal(companyCriteria);
	}

	//공원 업체  상세페이지
	@Override
	public ParkCompanyVO parkCompanyGetDetail(String cor_reg_no) throws Exception {
		log.info("공원 상세페이지"+cor_reg_no);
		
		return companyManageMapper.parkCompanyGetDetail(cor_reg_no);
	}

	//공원 엑셀 다운로드
	@Override
	public void parkCompanyGetExcel(ParkCompanyVO parkCompanyVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<ParkCompanyVO> list = companyManageMapper.parkCompanyGetExcel(parkCompanyVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 5000);
		sheet.setColumnWidth((short) 3, (short) 15000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("공원 업체 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));
		
		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("사업자 번호");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("업체 명");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("업체 대표자");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("업체 주소");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("업체 아이디");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("업체 등록일자");
		setHeaderCS(cs, font, cell);	
		
		int i = 2;

		for(ParkCompanyVO vo :list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String companyCreteDate = sdf.format(vo.getSys_cr_dt());
			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
	
			cell=row.createCell(0);
			cell.setCellValue(vo.getCor_reg_no());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getCompany_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getPresident_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getCompany_addr());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getCompany_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(companyCreteDate);
			setCmmnCS2(cs, cell);
			
			i++;
			
		}

		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"ParkCompanyList.xlsx\""));
		wb.write(response.getOutputStream());		
	}
			
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//화장실 업체목록
	@Override
	public List<ToiletCompanyVO> toiletCompanyGetList(CompanyCriteria companyCriteria) throws Exception {
		log.info("(service.toiletCompanyGetList().."+companyCriteria);
		
		return companyManageMapper.toiletCompanyGetList(companyCriteria);
	}

	//화장실 업체 총 갯수
	@Override
	public int toiletCompanyGetTotal(CompanyCriteria companyCriteria) throws Exception {
		log.info("(service.toiletCompanyGetTotal().."+companyCriteria);
		
		return companyManageMapper.toiletCompanyGetTotal(companyCriteria);
	}
	//화장실 업체 상세페이지
	@Override
	public ToiletCompanyVO toiletCompanyGetDetail(String cor_reg_no) throws Exception {
		log.info("화장실 업체 진입"+cor_reg_no);
		return companyManageMapper.toiletCompanyGetDetail(cor_reg_no);
	}
	
	//화장실 업체 엑셀 다운로드
	@Override
	public void toiletCompanyGetExcel(ToiletCompanyVO toiletCompanyVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<ToiletCompanyVO> list = companyManageMapper.toiletCompanyGetExcel(toiletCompanyVO);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth((short) 0, (short) 5000);
		sheet.setColumnWidth((short) 1, (short) 5000);
		sheet.setColumnWidth((short) 2, (short) 5000);
		sheet.setColumnWidth((short) 3, (short) 15000);
		sheet.setColumnWidth((short) 4, (short) 5000);
		sheet.setColumnWidth((short) 5, (short) 5000);
		
		Row row = sheet.createRow(0);
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font font = wb.createFont();
		cell = row.createCell(0);
		cell.setCellValue("화장실 업체 목록");
		setHeaderCS(cs, font, cell);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 5));
		
		row=sheet.createRow(1);
		cell=null;
		cs=wb.createCellStyle();
		font=wb.createFont();
		
		cell = row.createCell(0);
		cell.setCellValue("사업자 번호");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(1);
		cell.setCellValue("업체 명");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(2);
		cell.setCellValue("업체 대표자");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(3);
		cell.setCellValue("업체 주소");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(4);
		cell.setCellValue("업체 아이디");
		setHeaderCS(cs, font, cell);
		
		cell = row.createCell(5);
		cell.setCellValue("업체 등록일자");
		setHeaderCS(cs, font, cell);	
		
		int i = 2;

		for(ToiletCompanyVO vo :list) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String companyCreteDate = sdf.format(vo.getSys_cr_dt());
			
			row=sheet.createRow(i);
			cell=null;
			cs=wb.createCellStyle();
			font=wb.createFont();
	
			cell=row.createCell(0);
			cell.setCellValue(vo.getCor_reg_no());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(1);
			cell.setCellValue(vo.getCompany_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(2);
			cell.setCellValue(vo.getPresident_nm());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(3);
			cell.setCellValue(vo.getCompany_addr());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(4);
			cell.setCellValue(vo.getCompany_id());
			setCmmnCS2(cs, cell);
			
			cell=row.createCell(5);
			cell.setCellValue(companyCreteDate);
			setCmmnCS2(cs, cell);
			
			i++;
			
		}

		response.setHeader("Set-Cookie", "fileDownload=true; path=/"); 
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"ToiletCompanyList.xlsx\""));
		wb.write(response.getOutputStream());		
		
	}
	
}