package com.spring.rentcar.commons;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; //총 글의 개수
	private int startPage; //시작 페이지
	private int endPage; // 끝페이지
	private boolean prev; //이전
	private boolean next; //다음

	private int displayPageNum = 5; //한화면에 표시될 페이지 수

	private SearchCriteria cri;
	
	private void calcData() {
		
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) +1;
		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public SearchCriteria getCri() {
		return cri;
	}

	public void setCri(SearchCriteria cri) {
		this.cri = cri;
	}
	
	
	public String makeQuery(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
																		.queryParam("perPageNum", cri.getPerPageNum())
																		.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeSearch(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
																		.queryParam("perPageNum", cri.getPerPageNum())
																		.queryParam("searchType", cri.getSearchType())
																		.queryParam("keyWord", cri.getKeyWord())
																		.build();
		
		return uriComponents.toUriString();
	}
	
	private String encoding(String keyWord) {
		
		if(keyWord == null || keyWord.trim().length() == 0) {
			return "";
		}
		try {
			return URLEncoder.encode(keyWord, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			return "";
		}
		
	}

}
