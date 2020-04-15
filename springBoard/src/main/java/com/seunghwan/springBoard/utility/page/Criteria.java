package com.seunghwan.springBoard.utility.page;

import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {
	private int page;
	private int articlePerPage;
	private String searchType;
	private String keyword;

	public Criteria() {
		this(1, 10);
	}

	public String[] getTypeArr() {
		return this.searchType == null ? new String[0] : this.searchType.split("");
	}

	public String makeQuery() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("page", new Object[]{this.page})
				.queryParam("articlePerPage", new Object[]{this.getArticlePerPage()})
				.queryParam("searchType", new Object[]{this.getSearchType()})
				.queryParam("keyword", new Object[]{this.getKeyword()});
		return builder.toUriString();
	}

	public Criteria(int page, int articlePerPage) {
		this.page = page;
		this.articlePerPage = articlePerPage;
	}

	public int getStartArticleId() {
		return (this.page - 1) * this.articlePerPage;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getArticlePerPage() {
		return this.articlePerPage;
	}

	public void setArticlePerPage(int articlePerPage) {
		this.articlePerPage = articlePerPage;
	}

	public String getSearchType() {
		return this.searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyWord) {
		this.keyword = keyWord;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + this.page + ", articlePerPage=" + this.articlePerPage + ", searchType="
				+ this.searchType + ", keyword=" + this.keyword + "]";
	}
}