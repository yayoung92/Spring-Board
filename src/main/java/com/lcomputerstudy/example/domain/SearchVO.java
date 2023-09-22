package com.lcomputerstudy.example.domain;

public class SearchVO {
	private String keyWord;
	private String search;
	private int page;	//현재 페이지
	private int perPage;		//한 페이지당 보여질 게시물 갯수
	
	public SearchVO() {
		
	}
	public SearchVO(String keyWord, String search) {
		this.keyWord = keyWord;
		this.search = search;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	@Override
	public String toString() {
		return "SearchVO [keyWord=" + keyWord + ", search=" + search + ", page=" + page + ", perPage=" + perPage
				+ "]";
	}
	
}
