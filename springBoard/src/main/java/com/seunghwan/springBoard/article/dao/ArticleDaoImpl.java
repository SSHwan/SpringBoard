package com.seunghwan.springBoard.article.dao;

import com.seunghwan.springBoard.article.dto.ArticleDto;
import com.seunghwan.springBoard.utility.page.Criteria;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl implements ArticleDao {
	private static final String NAMESPACE = "com.seunghwan.springBoard.mappers.article.articleMapper";
	private final SqlSession sqlSession;

	@Inject
	public ArticleDaoImpl(SqlSession sqlSession) throws Exception {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ArticleDto> list(Criteria criteria) throws Exception {
		System.out.println("list : " + criteria);
		return this.sqlSession.selectList("com.seunghwan.springBoard.mappers.article.articleMapper.list", criteria);
	}

	@Override
	public int getTotalArticle(Criteria criteria) throws Exception {
		System.out.println("getTotalArticle criteria: " + criteria);
		return (Integer) this.sqlSession
				.selectOne("com.seunghwan.springBoard.mappers.article.articleMapper.getTotalArticle", criteria);
	}

	@Override
	public String getMaxArticleId() throws Exception {
		return (String) this.sqlSession
				.selectOne("com.seunghwan.springBoard.mappers.article.articleMapper.getMaxArticleId");
	}

	@Override
	public void insertArticle(ArticleDto articleDto) throws Exception {
		System.out.println(articleDto);
		this.sqlSession.insert("com.seunghwan.springBoard.mappers.article.articleMapper.insertArticle", articleDto);
	}

	@Override
	public void updateHit(int articleId) throws Exception {
		this.sqlSession.update("com.seunghwan.springBoard.mappers.article.articleMapper.updateHit", articleId);
	}

	@Override
	public ArticleDto getArticle(int articleId) throws Exception {
		return (ArticleDto) this.sqlSession
				.selectOne("com.seunghwan.springBoard.mappers.article.articleMapper.getArticle", articleId);
	}

	@Override
	public void modifyArticle(ArticleDto articleDto) throws Exception {
		this.sqlSession.update("com.seunghwan.springBoard.mappers.article.articleMapper.modifyArticle", articleDto);
	}

	@Override
	public void deleteArticle(int articleId) throws Exception {
		this.sqlSession.update("com.seunghwan.springBoard.mappers.article.articleMapper.deleteArticle", articleId);
	}

	@Override
	public void replyShape(ArticleDto articleDto) throws Exception {
		this.sqlSession.update("com.seunghwan.springBoard.mappers.article.articleMapper.replyShape", articleDto);
	}

	@Override
	public void insertReply(ArticleDto articleDto) throws Exception {
		this.sqlSession.insert("com.seunghwan.springBoard.mappers.article.articleMapper.insertReply", articleDto);
	}
}