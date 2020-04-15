package com.seunghwan.springBoard.article.service;

import com.seunghwan.springBoard.article.dao.ArticleDao;
import com.seunghwan.springBoard.article.dto.ArticleDto;
import com.seunghwan.springBoard.utility.page.Criteria;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {
	private final ArticleDao articleDao;

	@Inject
	public ArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public List<ArticleDto> list(Criteria criteria) throws Exception {
		return this.articleDao.list(criteria);
	}

	@Override
	public int getTotalArticle(Criteria criteria) throws Exception {
		return this.articleDao.getTotalArticle(criteria);
	}

	@Override
	public void createArticle(ArticleDto articleDto) throws Exception {
		this.articleDao.insertArticle(articleDto);
	}

	@Override
	@Transactional
	public ArticleDto viewArticle(int articleId) throws Exception {
		this.articleDao.updateHit(articleId);
		return this.articleDao.getArticle(articleId);
	}

	@Override
	public void modifyArticle(ArticleDto articleDto) throws Exception {
		this.articleDao.modifyArticle(articleDto);
	}

	@Override
	public void deleteArticle(int articleId) throws Exception {
		this.articleDao.deleteArticle(articleId);
	}

	@Override
	@Transactional
	public void articleReply(ArticleDto articleDto) throws Exception {
		this.articleDao.replyShape(articleDto);
		this.articleDao.insertReply(articleDto);
	}
}