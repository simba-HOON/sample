package snd.nfc.model;

public class MngVO {

	private int mng_seq;
	private String mng_name;
	private String mng_password;
	private String mng_phone;
	private String mng_grade;
	private String mng_comment;
	private String mng_uuid;
	private String mng_token;
	private String mng_cr_dt;
	private String mng_ud_dt;
	private String mng_use_yn;
	private String manager_yn;
	
	
	
	public int getMng_seq() {
		return mng_seq;
	}
	public void setMng_seq(int mng_seq) {
		this.mng_seq = mng_seq;
	}
	public String getMng_name() {
		return mng_name;
	}
	public void setMng_name(String mng_name) {
		this.mng_name = mng_name;
	}
	public String getMng_password() {
		return mng_password;
	}
	public void setMng_password(String mng_password) {
		this.mng_password = mng_password;
	}
	public String getMng_phone() {
		return mng_phone;
	}
	public void setMng_phone(String mng_phone) {
		this.mng_phone = mng_phone;
	}
	public String getMng_grade() {
		return mng_grade;
	}
	public void setMng_grade(String mng_grade) {
		this.mng_grade = mng_grade;
	}
	public String getMng_comment() {
		return mng_comment;
	}
	public void setMng_comment(String mng_comment) {
		this.mng_comment = mng_comment;
	}
	public String getMng_uuid() {
		return mng_uuid;
	}
	public void setMng_uuid(String mng_uuid) {
		this.mng_uuid = mng_uuid;
	}
	public String getMng_token() {
		return mng_token;
	}
	public void setMng_token(String mng_token) {
		this.mng_token = mng_token;
	}
	public String getMng_cr_dt() {
		return mng_cr_dt;
	}
	public void setMng_cr_dt(String mng_cr_dt) {
		this.mng_cr_dt = mng_cr_dt;
	}
	public String getMng_ud_dt() {
		return mng_ud_dt;
	}
	public void setMng_ud_dt(String mng_ud_dt) {
		this.mng_ud_dt = mng_ud_dt;
	}
	public String getMng_use_yn() {
		return mng_use_yn;
	}
	public void setMng_use_yn(String mng_use_yn) {
		this.mng_use_yn = mng_use_yn;
	}
	public String getManager_yn() {
		return manager_yn;
	}
	public void setManager_yn(String manager_yn) {
		this.manager_yn = manager_yn;
	}
	
	
	@Override
	public String toString() {
		return "MngVO [mng_seq=" + mng_seq + ", mng_name=" + mng_name + ", mng_password=" + mng_password
				+ ", mng_phone=" + mng_phone + ", mng_grade=" + mng_grade + ", mng_comment=" + mng_comment
				+ ", mng_uuid=" + mng_uuid + ", mng_token=" + mng_token + ", mng_cr_dt=" + mng_cr_dt + ", mng_ud_dt="
				+ mng_ud_dt + ", mng_use_yn=" + mng_use_yn + ", manager_yn=" + manager_yn + "]";
	}
	
}
