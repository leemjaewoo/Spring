package kr.or.ddit.util.model;

public class PageVO {
	private int page;      //페이지번호
	private int pageSize;  //페이지당 사이즈
	
	
	public PageVO() {
		
	}
	 
	
	public PageVO(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
}
