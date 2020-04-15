package com.seunghwan.springBoard.utility.page;

public class PageDto {
	private int total;
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev;
	private boolean next;
	private int pageNum = 10;
	private Criteria criteria;

	public PageDto(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		this.endPage = (int) Math.ceil((double) criteria.getPage() / (double) this.pageNum) * this.pageNum;
		this.startPage = this.endPage - this.pageNum + 1;
		this.realEnd = (int) Math.ceil((double) total / (double) criteria.getArticlePerPage());
		if (this.realEnd < this.endPage) {
			this.endPage = this.realEnd;
		}

		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
	}

	public PageDto(Criteria criteria, int total, int pageNum) {
		this.criteria = criteria;
		this.total = total;
		this.endPage = (int) Math.ceil((double) criteria.getPage() / (double) pageNum) * pageNum;
		this.startPage = this.endPage - pageNum + 1;
		this.realEnd = (int) Math.ceil((double) total / (double) criteria.getArticlePerPage());
		if (this.realEnd < this.endPage) {
			this.endPage = this.realEnd;
		}

		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
	}

	public int getTotal() {
		return this.total;
	}

	public int getStartPage() {
		return this.startPage;
	}

	public int getEndPage() {
		return this.endPage;
	}

	public boolean isPrev() {
		return this.prev;
	}

	public boolean isNext() {
		return this.next;
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public Criteria getCriteria() {
		return this.criteria;
	}

	public int getRealEnd() {
		return this.realEnd;
	}

	@Override
	public String toString() {
		return "PageDto [total=" + this.total + ", startPage=" + this.startPage + ", endPage=" + this.endPage
				+ ", prev=" + this.prev + ", next=" + this.next + ", pageNum=" + this.pageNum + ", criteria="
				+ this.criteria + "]";
	}
}