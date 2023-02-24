package snd.nfc.model;

import java.util.Date;

public class ParkBscVO {

	private String park_tag_id;
	
	private int park_seq;
	
	private String park_nm;
	
	private String park_owner;
	
	private String park_impl_cp_id;
	
	private int park_wk_seq;
	
	private String park_wk_cp_id;
	
	private Date park_bsc_info_cr_dt;

	
	
	public String getPark_tag_id() {
		return park_tag_id;
	}

	public void setPark_tag_id(String park_tag_id) {
		this.park_tag_id = park_tag_id;
	}

	public int getPark_seq() {
		return park_seq;
	}

	public void setPark_seq(int park_seq) {
		this.park_seq = park_seq;
	}

	public String getPark_nm() {
		return park_nm;
	}

	public void setPark_nm(String park_nm) {
		this.park_nm = park_nm;
	}

	public String getPark_owner() {
		return park_owner;
	}

	public void setPark_owner(String park_owner) {
		this.park_owner = park_owner;
	}

	public String getPark_impl_cp_id() {
		return park_impl_cp_id;
	}

	public void setPark_impl_cp_id(String park_impl_cp_id) {
		this.park_impl_cp_id = park_impl_cp_id;
	}

	public int getPark_wk_seq() {
		return park_wk_seq;
	}

	public void setPark_wk_seq(int park_wk_seq) {
		this.park_wk_seq = park_wk_seq;
	}

	public String getPark_wk_cp_id() {
		return park_wk_cp_id;
	}

	public void setPark_wk_cp_id(String park_wk_cp_id) {
		this.park_wk_cp_id = park_wk_cp_id;
	}

	public Date getPark_bsc_info_cr_dt() {
		return park_bsc_info_cr_dt;
	}

	public void setPark_bsc_info_cr_dt(Date park_bsc_info_cr_dt) {
		this.park_bsc_info_cr_dt = park_bsc_info_cr_dt;
	}

	@Override
	public String toString() {
		return "ParkBscVO [park_tag_id=" + park_tag_id + ", park_seq=" + park_seq + ", park_nm=" + park_nm
				+ ", park_owner=" + park_owner + ", park_impl_cp_id=" + park_impl_cp_id + ", park_wk_seq=" + park_wk_seq
				+ ", park_wk_cp_id=" + park_wk_cp_id + ", park_bsc_info_cr_dt=" + park_bsc_info_cr_dt + "]";
	}
	

	
}
