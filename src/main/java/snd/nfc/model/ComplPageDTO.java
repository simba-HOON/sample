package snd.nfc.model;

public class ComplPageDTO {

	private int pageStart2;
	
	private int pageEnd2;
	
	private boolean next2, prev2;
	
	private int total2;
	
	private ComplCriteria complCriteria;
	
	//생성자 (클래스 호출 시 각 변수값을 초기화)
	public ComplPageDTO(ComplCriteria complCriteria, int total2) {
		
		//각 부분 초기화
		this.complCriteria=complCriteria;
		this.total2=total2;
		
		//페이지 끝 번호
		this.pageEnd2=(int)(Math.ceil(complCriteria.getPageNum2()/10.0))*10;
		//페이지 시작 번호
		this.pageStart2=this.pageEnd2-9;
		//페이지 마지막 번호
		int realEnd2=(int)(Math.ceil(total2*1.0/complCriteria.getAmount2()));
		
		//페이지 끝 유효성 검사
		if (realEnd2<pageEnd2) {
			this.pageEnd2=realEnd2;			
		}
		
		//이전 버튼 값 초기화
		this.prev2=this.pageStart2>1;
		
		//다음 버튼 값 초기화
		this.next2=this.pageEnd2<realEnd2;
	}

	
	
	
	public int getPageStart2() {
		return pageStart2;
	}

	public void setPageStart2(int pageStart2) {
		this.pageStart2 = pageStart2;
	}

	public int getPageEnd2() {
		return pageEnd2;
	}

	public void setPageEnd2(int pageEnd2) {
		this.pageEnd2 = pageEnd2;
	}

	public boolean isNext2() {
		return next2;
	}

	public void setNext2(boolean next2) {
		this.next2 = next2;
	}

	public boolean isPrev2() {
		return prev2;
	}

	public void setPrev2(boolean prev2) {
		this.prev2 = prev2;
	}

	public int getTotal2() {
		return total2;
	}

	public void setTotal2(int total2) {
		this.total2 = total2;
	}

	public ComplCriteria getComplCriteria() {
		return complCriteria;
	}

	public void setComplCriteria(ComplCriteria complCriteria) {
		this.complCriteria = complCriteria;
	}

	@Override
	public String toString() {
		return "ComplPageDTO [pageStart2=" + pageStart2 + ", pageEnd2=" + pageEnd2 + ", next2=" + next2 + ", prev2="
				+ prev2 + ", total2=" + total2 + ", complCriteria=" + complCriteria + "]";
	}

	
}
