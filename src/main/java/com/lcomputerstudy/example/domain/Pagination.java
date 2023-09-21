package com.lcomputerstudy.example.domain;

public class Pagination {
	int count;				//선택 한 테이블에 등록 된 총 컬럼 수
	int page = 1;				//현재 페이지번호
	int pageNum;			//getTotal
	int startPage;			//시작페이지(ex,1,6,11)
	int endPage;			//끝 페이지(ex,5,10,15)
	int lastPage;			//(getTotal/화면에 표시할 갯수), pagination 마지막 번호
	int prevPage;			//pagination의 이전 목록
	int nextPage;			//pagination의 다음 목록
	public static final int pageUnit=5;		//한번에 불러 올 pagination 수 
	public static final int perPage=5;		//한번에 불러 올 getTotal 수
	private SearchVO searchVO;

	public SearchVO getSearchVO() {
		return searchVO;
	}
	public void setSearchVO(SearchVO searchVO) {
		this.searchVO = searchVO;
	}
	public void init() {
		pageNum = (page-1)*perPage;
		startPage =((page-1)/pageUnit)*pageUnit+1;
		lastPage = (int)Math.ceil(count / (float)perPage);
		endPage = startPage+pageUnit-1;
		endPage = endPage < lastPage ? endPage : lastPage;
		prevPage=(startPage-pageUnit);
		nextPage=(startPage+pageUnit);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
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
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public int getPerPage() {
		return perPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}
