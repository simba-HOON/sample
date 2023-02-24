package snd.nfc.model;

import java.util.Date;

public class ToiletCompanyVO {
	
	private String cor_reg_no;
	
	private String company_nm;
	
	private String president_nm;
	
	private String company_addr;
	
	private String company_tel;
	
	private String company_fax;
	
	private String company_busi;
	
	private String company_id;
	
	private String design_yn;
	
	private String construction_yn;
	
	private String supervision_yn;
	
	private String sys_cr_user_id;
	
	private String sys_ud_user_id;
	
	private Date sys_cr_dt;
	
	private Date sys_ud_dt;

	
	
	public String getCor_reg_no() {
		return cor_reg_no;
	}

	public void setCor_reg_no(String cor_reg_no) {
		this.cor_reg_no = cor_reg_no;
	}

	public String getCompany_nm() {
		return company_nm;
	}

	public void setCompany_nm(String company_nm) {
		this.company_nm = company_nm;
	}

	public String getPresident_nm() {
		return president_nm;
	}

	public void setPresident_nm(String president_nm) {
		this.president_nm = president_nm;
	}

	public String getCompany_addr() {
		return company_addr;
	}

	public void setCompany_addr(String company_addr) {
		this.company_addr = company_addr;
	}

	public String getCompany_tel() {
		return company_tel;
	}

	public void setCompany_tel(String company_tel) {
		this.company_tel = company_tel;
	}

	public String getCompany_fax() {
		return company_fax;
	}

	public void setCompany_fax(String company_fax) {
		this.company_fax = company_fax;
	}

	public String getCompany_busi() {
		return company_busi;
	}

	public void setCompany_busi(String company_busi) {
		this.company_busi = company_busi;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getDesign_yn() {
		return design_yn;
	}

	public void setDesign_yn(String design_yn) {
		this.design_yn = design_yn;
	}

	public String getConstruction_yn() {
		return construction_yn;
	}

	public void setConstruction_yn(String construction_yn) {
		this.construction_yn = construction_yn;
	}

	public String getSupervision_yn() {
		return supervision_yn;
	}

	public void setSupervision_yn(String supervision_yn) {
		this.supervision_yn = supervision_yn;
	}

	public String getSys_cr_user_id() {
		return sys_cr_user_id;
	}

	public void setSys_cr_user_id(String sys_cr_user_id) {
		this.sys_cr_user_id = sys_cr_user_id;
	}

	public String getSys_ud_user_id() {
		return sys_ud_user_id;
	}

	public void setSys_ud_user_id(String sys_ud_user_id) {
		this.sys_ud_user_id = sys_ud_user_id;
	}

	public Date getSys_cr_dt() {
		return sys_cr_dt;
	}

	public void setSys_cr_dt(Date sys_cr_dt) {
		this.sys_cr_dt = sys_cr_dt;
	}

	public Date getSys_ud_dt() {
		return sys_ud_dt;
	}

	public void setSys_ud_dt(Date sys_ud_dt) {
		this.sys_ud_dt = sys_ud_dt;
	}

	@Override
	public String toString() {
		return "GrsCompanyVO [cor_reg_no=" + cor_reg_no + ", company_nm=" + company_nm + ", president_nm="
				+ president_nm + ", company_addr=" + company_addr + ", company_tel=" + company_tel + ", company_fax="
				+ company_fax + ", company_busi=" + company_busi + ", company_id=" + company_id + ", design_yn="
				+ design_yn + ", construction_yn=" + construction_yn + ", supervision_yn=" + supervision_yn
				+ ", sys_cr_user_id=" + sys_cr_user_id + ", sys_ud_user_id=" + sys_ud_user_id + ", sys_cr_dt="
				+ sys_cr_dt + ", sys_ud_dt=" + sys_ud_dt + "]";
	}
	
}
