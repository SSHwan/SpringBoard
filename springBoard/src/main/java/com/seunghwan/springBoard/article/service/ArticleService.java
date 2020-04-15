package com.seunghwan.springBoard.article.service;

import com.seunghwan.springBoard.article.dto.ArticleDto;
import com.seunghwan.springBoard.utility.page.Criteria;
import java.util.List;

public interface ArticleService {
	List<ArticleDto> list(Criteria var1) throws Exception;

	int getTotalArticle(Criteria var1) throws Exception;

	void createArticle(ArticleDto var1) throws Exception;

	ArticleDto viewArticle(int var1) throws Exception;

	void modifyArticle(ArticleDto var1) throws Exception;

	void deleteArticle(int var1) throws Exception;

	void articleReply(ArticleDto var1) throws Exception;
}