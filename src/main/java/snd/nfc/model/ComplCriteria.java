package snd.nfc.model;

public class ComplCriteria {
	
	/* 현재 페이지 번호 */
    private int pageNum2;
    
    /* 페이지 표시 개수 */
    private int amount2;
    
    //페이지 스킵
    private int skip2;
    
    /* 검색 타입 */
    private String type2;
    
    /* 검색 키워드 */
    private String keyword2;
    
    /* Criteria 생성자 */
    public ComplCriteria(int pageNum2, int amount2) {
        this.pageNum2 = pageNum2;
        this.amount2 = amount2;
        this.skip2 = (pageNum2-1)*amount2;
    }
    
    /* Criteria 기본 생성자 */
    public ComplCriteria(){
        this(1,10);
    }
    
    /* 검색 타입 데이터 배열 변환 */
    public String[] getTypeArr2() {
        return type2 == null? new String[] {}:type2.split("");
    }

    
    
    
	public int getPageNum2() {
		return pageNum2;
	}

	public void setPageNum2(int pageNum2) {
		this.pageNum2 = pageNum2;
		this.skip2 = (pageNum2-1)*this.amount2;
	}

	public int getAmount2() {
		return amount2;
	}

	public void setAmount2(int amount2) {
		this.amount2 = amount2;
		this.skip2=(this.pageNum2-1)*amount2;
	}

	public int getSkip2() {
		return skip2;
	}

	public void setSkip2(int skip2) {
		this.skip2 = skip2;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	@Override
	public String toString() {
		return "ComplCriteria [pageNum2=" + pageNum2 + ", amount2=" + amount2 + ", skip2=" + skip2 + ", type2=" + type2
				+ ", keyword2=" + keyword2 + "]";
	}

     
}
