package com.seunghwan.springBoard.article.dto;

import java.sql.Timestamp;

public class ArticleDto {
	int articleId;
	String userId;
	String userName;
	String articleTitle;
	String articleContent;
	Timestamp articleDate;
	int access;
	int articleHit;
	int articleGroup;
	int articleStep;
	int articleIndent;

	public ArticleDto() {
	}

	public ArticleDto(int articleId, String userId, String userName, String articleTitle, String articleContent,
			Timestamp articleDate, int access, int articleHit, int articleGroup, int articleStep, int articleIndent) {
		this.articleId = articleId;
		this.userId = userId;
		this.userName = userName;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleDate = articleDate;
		this.access = access;
		this.articleHit = articleHit;
		this.articleGroup = articleGroup;
		this.articleStep = articleStep;
		this.articleIndent = articleIndent;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAccess() {
		return this.access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public int getArticleId() {
		return this.articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Timestamp getArticleDate() {
		return this.articleDate;
	}

	public void setArticleDate(Timestamp articleDate) {
		this.articleDate = articleDate;
	}

	public int getArticleHit() {
		return this.articleHit;
	}

	public void setArticleHit(int articleHit) {
		this.articleHit = articleHit;
	}

	public int getArticleGroup() {
		return this.articleGroup;
	}

	public void setArticleGroup(int articleGroup) {
		this.articleGroup = articleGroup;
	}

	public int getArticleStep() {
		return this.articleStep;
	}

	public void setArticleStep(int articleStep) {
		this.articleStep = articleStep;
	}

	public int getArticleIndent() {
		return this.articleIndent;
	}

	public void setArticleIndent(int articleIndent) {
		this.articleIndent = articleIndent;
	}

	@Override
	public String toString() {
		return "ArticleDto [articleId=" + this.articleId + ", userId=" + this.userId + ", userName=" + this.userName
				+ ", articleTitle=" + this.articleTitle + ", articleContent=" + this.articleContent + ", articleDate="
				+ this.articleDate + ", access=" + this.access + ", articleHit=" + this.articleHit + ", articleGroup="
				+ this.articleGroup + ", articleStep=" + this.articleStep + ", articleIndent=" + this.articleIndent
				+ "]";
	}
}