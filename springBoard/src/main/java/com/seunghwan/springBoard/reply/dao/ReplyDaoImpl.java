package com.seunghwan.springBoard.reply.dao;

import com.seunghwan.springBoard.reply.dto.ReplyDto;
import com.seunghwan.springBoard.utility.page.Criteria;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	private static final String NAMESPACE = "com.seunghwan.springBoard.mappers.reply.replyMapper";
	private final SqlSession sqlSession;

	@Inject
	public ReplyDaoImpl(SqlSession sqlSession) throws Exception {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ReplyDto> listReply(Criteria criteria, int articleId) throws Exception {
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("criteria", criteria);
		paramMap.put("articleId", articleId);
		return this.sqlSession.selectList("com.seunghwan.springBoard.mappers.reply.replyMapper.listReply", paramMap);
	}

	@Override
	public int countReply(int articleId) throws Exception {
		return (Integer) this.sqlSession.selectOne("com.seunghwan.springBoard.mappers.reply.replyMapper.countReply",
				articleId);
	}

	@Override
	public int insertReply(ReplyDto replyDto) throws Exception {
		return this.sqlSession.insert("com.seunghwan.springBoard.mappers.reply.replyMapper.insertReply", replyDto);
	}

	@Override
	public int updateReply(ReplyDto replyDto) throws Exception {
		return this.sqlSession.update("com.seunghwan.springBoard.mappers.reply.replyMapper.updateReply", replyDto);
	}

	@Override
	public int deleteReply(int reply_id) throws Exception {
		return this.sqlSession.delete("com.seunghwan.springBoard.mappers.reply.replyMapper.deleteReply", reply_id);
	}
}