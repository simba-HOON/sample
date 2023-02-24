package snd.nfc.model;

import java.util.Date;

public class ToiletComplVO {

	private int compl_seq;
	
	private String compl_toilet_tag_id;
	
	private int compl_category;
	
	private String compl_content;
	
	private String complt_name;
	
	private String complt_phone;
	
	private String complt_email;
	
	private Date complt_compl_cr_dt;

	public int getCompl_seq() {
		return compl_seq;
	}

	public void setCompl_seq(int compl_seq) {
		this.compl_seq = compl_seq;
	}

	public String getCompl_toilet_tag_id() {
		return compl_toilet_tag_id;
	}

	public void setCompl_toilet_tag_id(String compl_toilet_tag_id) {
		this.compl_toilet_tag_id = compl_toilet_tag_id;
	}

	public int getCompl_category() {
		return compl_category;
	}

	public void setCompl_category(int compl_category) {
		this.compl_category = compl_category;
	}

	public String getCompl_content() {
		return compl_content;
	}

	public void setCompl_content(String compl_content) {
		this.compl_content = compl_content;
	}

	public String getComplt_name() {
		return complt_name;
	}

	public void setComplt_name(String complt_name) {
		this.complt_name = complt_name;
	}

	public String getComplt_phone() {
		return complt_phone;
	}

	public void setComplt_phone(String complt_phone) {
		this.complt_phone = complt_phone;
	}

	public String getComplt_email() {
		return complt_email;
	}

	public void setComplt_email(String complt_email) {
		this.complt_email = complt_email;
	}

	public Date getComplt_compl_cr_dt() {
		return complt_compl_cr_dt;
	}

	public void setComplt_compl_cr_dt(Date complt_compl_cr_dt) {
		this.complt_compl_cr_dt = complt_compl_cr_dt;
	}

	@Override
	public String toString() {
		return "ToiletComplVO [compl_seq=" + compl_seq + ", compl_toilet_tag_id=" + compl_toilet_tag_id
				+ ", compl_category=" + compl_category + ", compl_content=" + compl_content + ", complt_name="
				+ complt_name + ", complt_phone=" + complt_phone + ", complt_email=" + complt_email
				+ ", complt_compl_cr_dt=" + complt_compl_cr_dt + "]";
	}

}
