package com.seunghwan.springBoard.article.dao;

import com.seunghwan.springBoard.article.dto.ArticleDto;
import com.seunghwan.springBoard.utility.page.Criteria;
import java.util.List;

public interface ArticleDao {
	List<ArticleDto> list(Criteria var1) throws Exception;

	int getTotalArticle(Criteria var1) throws Exception;

	String getMaxArticleId() throws Exception;

	void insertArticle(ArticleDto var1) throws Exception;

	void updateHit(int var1) throws Exception;

	ArticleDto getArticle(int var1) throws Exception;

	void modifyArticle(ArticleDto var1) throws Exception;

	void deleteArticle(int var1) throws Exception;

	void replyShape(ArticleDto var1) throws Exception;

	void insertReply(ArticleDto var1) throws Exception;
}