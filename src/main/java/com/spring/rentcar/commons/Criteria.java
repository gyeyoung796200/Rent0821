package com.spring.rentcar.commons;

public class Criteria {

	private int page;  //현재 페이지
	private int perPageNum; //한페이지당 글의 개수

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		if(page <= 0) {
			this.page = 1;
			return ;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return ;
		}
		this.perPageNum = perPageNum;
	}

	public int getPageStart() {
		
		return (this.page -1) * perPageNum;
	}
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

}
