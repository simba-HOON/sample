package snd.nfc.model;

public class BscPageDTO {

	private int pageStart;
	
	private int pageEnd;
	
	private boolean next, prev;
	
	private int total;
	
	private BscCriteria cri;
	
	//생성자 (클래스 호출 시 각 변수값을 초기화)
	public BscPageDTO(BscCriteria cri, int total) {
		
		//각 부분 초기화
		this.cri=cri;
		this.total=total;
		//페이지 끝 번호
		this.pageEnd=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//페이지 시작 번호
		this.pageStart=this.pageEnd-9;
		//페이지 마지막 번호
		int realEnd=(int)(Math.ceil(total*1.0/cri.getAmount()));
		//페이지 끝 유효성 검사
		if (realEnd<pageEnd) {
			this.pageEnd=realEnd;			
		}
		//이전 버튼 값 초기화
		this.prev=this.pageStart>1;
		//다음 버튼 값 초기화
		this.next=this.pageEnd<realEnd;
	}

	
	
	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public BscCriteria getCri() {
		return cri;
	}

	public void setCri(BscCriteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageDTO [pageStart=" + pageStart + ", pageEnd=" + pageEnd + ", next=" + next + ", prev=" + prev
				+ ", total=" + total + ", cri=" + cri + "]";
	}
		
	
}
