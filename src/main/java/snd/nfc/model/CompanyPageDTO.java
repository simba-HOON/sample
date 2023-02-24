package snd.nfc.model;

public class CompanyPageDTO {

	private int pageStart3;
	
	private int pageEnd3;
	
	private boolean next3, prev3;
	
	private int total3;
	
	private CompanyCriteria companyCriteria;
	
	public CompanyPageDTO(CompanyCriteria companyCriteria, int total3) {
		
		this.companyCriteria=companyCriteria;
		this.total3=total3;
		
		this.pageEnd3=(int)(Math.ceil(companyCriteria.getPageNum3()/10.0))*10;
		this.pageStart3=this.pageEnd3-9;
		
		int realEnd3=(int)(Math.ceil(total3*1.0/companyCriteria.getAmount3()));
		
		if(realEnd3<pageEnd3) {
			this.pageEnd3=realEnd3;
		}
		
		this.prev3=this.pageStart3>1;
		this.next3=this.pageEnd3<realEnd3;
	}

	
	
	public int getPageStart3() {
		return pageStart3;
	}

	public void setPageStart3(int pageStart3) {
		this.pageStart3 = pageStart3;
	}

	public int getPageEnd3() {
		return pageEnd3;
	}

	public void setPageEnd3(int pageEnd3) {
		this.pageEnd3 = pageEnd3;
	}

	public boolean isNext3() {
		return next3;
	}

	public void setNext3(boolean next3) {
		this.next3 = next3;
	}

	public boolean isPrev3() {
		return prev3;
	}

	public void setPrev3(boolean prev3) {
		this.prev3 = prev3;
	}

	public int getTotal3() {
		return total3;
	}

	public void setTotal3(int total3) {
		this.total3 = total3;
	}

	public CompanyCriteria getCompanyCriteria() {
		return companyCriteria;
	}

	public void setCompanyCriteria(CompanyCriteria companyCriteria) {
		this.companyCriteria = companyCriteria;
	}

	
	
	@Override
	public String toString() {
		return "CompanyPageDTO [pageStart3=" + pageStart3 + ", pageEnd3=" + pageEnd3 + ", next3=" + next3 + ", prev3="
				+ prev3 + ", total3=" + total3 + ", companyCriteria=" + companyCriteria + "]";
	}
	
		
	
}
