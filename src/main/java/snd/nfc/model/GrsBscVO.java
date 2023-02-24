package snd.nfc.model;

import java.util.Date;

public class GrsBscVO {

	private int grs_bsc_seq;
	
	private String grs_tag_id;
	
	private String grs_tag_sr_no;
	
	private String grs_nm;
	
	private String grs_owner;
	
	private String impl_cp_id;
	
	private int wk_seq;
	
	private String wk_cp_id;
	
	private String latitude;
	
	private String longitude;
	
	private String grs_addr;
	
	private String scarlet_diam;
	
	private String tr_height;
	
	private String crw_height;
	
	private String crw_diam;
	
	private String pest_dmg_state;
	
	private String tr_state;
	
	private String bsc_info_desc;
	
	private String bsc_img;
	
	private Date bsc_info_cr_dt;
	
	private Date bsc_info_ud_dt;
	
	private Date bsc_info_de_dt;
	
	private String data_use_yn;
	
	
	

	public int getGrs_bsc_seq() {
		return grs_bsc_seq;
	}

	public void setGrs_bsc_seq(int grs_bsc_seq) {
		this.grs_bsc_seq = grs_bsc_seq;
	}

	public String getGrs_tag_id() {
		return grs_tag_id;
	}

	public void setGrs_tag_id(String grs_tag_id) {
		this.grs_tag_id = grs_tag_id;
	}

	public String getGrs_tag_sr_no() {
		return grs_tag_sr_no;
	}

	public void setGrs_tag_sr_no(String grs_tag_sr_no) {
		this.grs_tag_sr_no = grs_tag_sr_no;
	}

	public String getGrs_nm() {
		return grs_nm;
	}

	public void setGrs_nm(String grs_nm) {
		this.grs_nm = grs_nm;
	}

	public String getGrs_owner() {
		return grs_owner;
	}

	public void setGrs_owner(String grs_owner) {
		this.grs_owner = grs_owner;
	}

	public String getImpl_cp_id() {
		return impl_cp_id;
	}

	public void setImpl_cp_id(String impl_cp_id) {
		this.impl_cp_id = impl_cp_id;
	}

	public int getWk_seq() {
		return wk_seq;
	}

	public void setWk_seq(int wk_seq) {
		this.wk_seq = wk_seq;
	}

	public String getWk_cp_id() {
		return wk_cp_id;
	}

	public void setWk_cp_id(String wk_cp_id) {
		this.wk_cp_id = wk_cp_id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getGrs_addr() {
		return grs_addr;
	}

	public void setGrs_addr(String grs_addr) {
		this.grs_addr = grs_addr;
	}

	public String getScarlet_diam() {
		return scarlet_diam;
	}

	public void setScarlet_diam(String scarlet_diam) {
		this.scarlet_diam = scarlet_diam;
	}

	public String getTr_height() {
		return tr_height;
	}

	public void setTr_height(String tr_height) {
		this.tr_height = tr_height;
	}

	public String getCrw_height() {
		return crw_height;
	}

	public void setCrw_height(String crw_height) {
		this.crw_height = crw_height;
	}

	public String getCrw_diam() {
		return crw_diam;
	}

	public void setCrw_diam(String crw_diam) {
		this.crw_diam = crw_diam;
	}

	public String getPest_dmg_state() {
		return pest_dmg_state;
	}

	public void setPest_dmg_state(String pest_dmg_state) {
		this.pest_dmg_state = pest_dmg_state;
	}

	public String getTr_state() {
		return tr_state;
	}

	public void setTr_state(String tr_state) {
		this.tr_state = tr_state;
	}

	public String getBsc_info_desc() {
		return bsc_info_desc;
	}

	public void setBsc_info_desc(String bsc_info_desc) {
		this.bsc_info_desc = bsc_info_desc;
	}

	public String getBsc_img() {
		return bsc_img;
	}

	public void setBsc_img(String bsc_img) {
		this.bsc_img = bsc_img;
	}

	public Date getBsc_info_cr_dt() {
		return bsc_info_cr_dt;
	}

	public void setBsc_info_cr_dt(Date bsc_info_cr_dt) {
		this.bsc_info_cr_dt = bsc_info_cr_dt;
	}

	public Date getBsc_info_ud_dt() {
		return bsc_info_ud_dt;
	}

	public void setBsc_info_ud_dt(Date bsc_info_ud_dt) {
		this.bsc_info_ud_dt = bsc_info_ud_dt;
	}

	public Date getBsc_info_de_dt() {
		return bsc_info_de_dt;
	}

	public void setBsc_info_de_dt(Date bsc_info_de_dt) {
		this.bsc_info_de_dt = bsc_info_de_dt;
	}

	public String getData_use_yn() {
		return data_use_yn;
	}

	public void setData_use_yn(String data_use_yn) {
		this.data_use_yn = data_use_yn;
	}

	@Override
	public String toString() {
		return "GrsBscVO [grs_bsc_seq=" + grs_bsc_seq + ", grs_tag_id=" + grs_tag_id + ", grs_tag_sr_no="
				+ grs_tag_sr_no + ", grs_nm=" + grs_nm + ", grs_owner=" + grs_owner + ", impl_cp_id=" + impl_cp_id
				+ ", wk_seq=" + wk_seq + ", wk_cp_id=" + wk_cp_id + ", latitude=" + latitude + ", longitude="
				+ longitude + ", grs_addr=" + grs_addr + ", scarlet_diam=" + scarlet_diam + ", tr_height=" + tr_height
				+ ", crw_height=" + crw_height + ", crw_diam=" + crw_diam + ", pest_dmg_state=" + pest_dmg_state
				+ ", tr_state=" + tr_state + ", bsc_info_desc=" + bsc_info_desc + ", bsc_img=" + bsc_img
				+ ", bsc_info_cr_dt=" + bsc_info_cr_dt + ", bsc_info_ud_dt=" + bsc_info_ud_dt + ", bsc_info_de_dt="
				+ bsc_info_de_dt + ", data_use_yn=" + data_use_yn + "]";
	}
	
}
