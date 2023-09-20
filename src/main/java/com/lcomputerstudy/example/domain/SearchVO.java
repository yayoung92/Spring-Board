package com.lcomputerstudy.example.domain;

public class SearchVO {
	private String keyWord;
	private String search;
	private int pageNum;	//현재 페이지
	private int amount;		//한 페이지당 보여질 게시물 갯수
	
	public SearchVO() {
	}
	public SearchVO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
		return "SearchVO [keyWord=" + keyWord + ", search=" + search + ", pageNum=" + pageNum + ", amount=" + amount
				+ "]";
	}
	
}
