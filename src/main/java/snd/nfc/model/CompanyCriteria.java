package snd.nfc.model;

public class CompanyCriteria {
	//현재 페이지 번호
	private int pageNum3;
	//페이지 표시 개수
	private int amount3;
	//페이지 스킵
	private int skip3;
	//검색 타입
	private String type3;
	//검색 키워드
	private String keyword3;
	//Criteria 생성자
	public CompanyCriteria(int pageNum3, int amount3) {
		this.pageNum3=pageNum3;
		this.amount3=amount3;
		this.skip3=(pageNum3-1)*amount3;
	}
	//Criteria 기본생성자
	public CompanyCriteria() {
		this(1,10);
	}
	//검색 타입 데이터 배열 변환
	public String[] getTypeArr3() {
		return type3==null? new String[] {}:type3.split("");
	}
	
	
	
	public int getPageNum3() {
		return pageNum3;
	}
	public void setPageNum3(int pageNum3) {
		this.pageNum3 = pageNum3;
		this.skip3=(pageNum3-1)*this.amount3;
	}
	public int getAmount3() {
		return amount3;
	}
	public void setAmount3(int amount3) {
		this.amount3 = amount3;
		this.skip3=(this.pageNum3-1)*amount3;
	}
	public int getSkip3() {
		return skip3;
	}
	public void setSkip3(int skip3) {
		this.skip3 = skip3;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getKeyword3() {
		return keyword3;
	}
	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}
	
	
	@Override
	public String toString() {
		return "CompanyCriteria [pageNum3=" + pageNum3 + ", amount3=" + amount3 + ", skip3=" + skip3 + ", type3="
				+ type3 + ", keyword3=" + keyword3 + "]";
	}
	
		
}
