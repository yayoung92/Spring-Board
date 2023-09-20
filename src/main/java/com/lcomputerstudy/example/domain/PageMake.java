package com.lcomputerstudy.example.domain;

public class PageMake {
	private int startPage;		//시작페이지
	private int endPage;		//끝 페이지
	private boolean prevPage;	//이전페이지 유무
	private boolean nextPage;	//다음페이지 유무
	private int total;			//전체 게시물 수
	private SearchVO searchvo;
	
	public PageMake(SearchVO searchvo, int total) {
		this.searchvo = searchvo;
		this.total = total;
		int currentPage = searchvo.getPageNum();
		this.startPage = ((currentPage -1)/5) * 5+1;
		this.endPage = this.startPage + 4;
		
		int realEnd = (int)(Math.ceil(total * 1.0/searchvo.getAmount()));
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prevPage = this.startPage > 1;
		this.nextPage = this.endPage > realEnd;
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

	public boolean isPrevPage() {
		return prevPage;
	}

	public void setPrevPage(boolean prevPage) {
		this.prevPage = prevPage;
	}

	public boolean isNextPage() {
		return nextPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public SearchVO getSearchvo() {
		return searchvo;
	}

	public void setSearchvo(SearchVO searchvo) {
		this.searchvo = searchvo;
	}

	@Override
	public String toString() {
		return "PageMake [startPage=" + startPage + ", endPage=" + endPage + ", prevPage=" + prevPage + ", nextPage="
				+ nextPage + ", total=" + total + ", searchvo=" + searchvo + "]";
	}
	
}
