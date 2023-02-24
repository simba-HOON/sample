package snd.nfc.model;

import java.util.Date;

public class ToiletBscVO {

	private String toilet_tag_id;
	
	private int toilet_seq;
	
	private String toilet_nm;
	
	private String toilet_owner;
	
	private String toilet_impl_cp_id;
	
	private int toilet_wk_seq;
	
	private String toilet_wk_cp_id;
	
	private Date toilet_bsc_info_cr_dt;
	
	
	

	public String getToilet_tag_id() {
		return toilet_tag_id;
	}

	public void setToilet_tag_id(String toilet_tag_id) {
		this.toilet_tag_id = toilet_tag_id;
	}

	public int getToilet_seq() {
		return toilet_seq;
	}

	public void setToilet_seq(int toilet_seq) {
		this.toilet_seq = toilet_seq;
	}

	public String getToilet_nm() {
		return toilet_nm;
	}

	public void setToilet_nm(String toilet_nm) {
		this.toilet_nm = toilet_nm;
	}

	public String getToilet_owner() {
		return toilet_owner;
	}

	public void setToilet_owner(String toilet_owner) {
		this.toilet_owner = toilet_owner;
	}

	public String getToilet_impl_cp_id() {
		return toilet_impl_cp_id;
	}

	public void setToilet_impl_cp_id(String toilet_impl_cp_id) {
		this.toilet_impl_cp_id = toilet_impl_cp_id;
	}

	public int getToilet_wk_seq() {
		return toilet_wk_seq;
	}

	public void setToilet_wk_seq(int toilet_wk_seq) {
		this.toilet_wk_seq = toilet_wk_seq;
	}

	public String getToilet_wk_cp_id() {
		return toilet_wk_cp_id;
	}

	public void setToilet_wk_cp_id(String toilet_wk_cp_id) {
		this.toilet_wk_cp_id = toilet_wk_cp_id;
	}

	public Date getToilet_bsc_info_cr_dt() {
		return toilet_bsc_info_cr_dt;
	}

	public void setToilet_bsc_info_cr_dt(Date toilet_bsc_info_cr_dt) {
		this.toilet_bsc_info_cr_dt = toilet_bsc_info_cr_dt;
	}

	@Override
	public String toString() {
		return "ToiletBscVO [toilet_tag_id=" + toilet_tag_id + ", toilet_seq=" + toilet_seq + ", toilet_nm=" + toilet_nm
				+ ", toilet_owner=" + toilet_owner + ", toilet_impl_cp_id=" + toilet_impl_cp_id + ", toilet_wk_seq="
				+ toilet_wk_seq + ", toilet_wk_cp_id=" + toilet_wk_cp_id + ", toilet_bsc_info_cr_dt="
				+ toilet_bsc_info_cr_dt + "]";
	}

	
}
