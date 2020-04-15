package com.seunghwan.springBoard.reply.service;

import com.seunghwan.springBoard.reply.dao.ReplyDao;
import com.seunghwan.springBoard.reply.dto.ReplyDto;
import com.seunghwan.springBoard.utility.page.Criteria;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
	private final ReplyDao replyDao;

	@Inject
	public ReplyServiceImpl(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<ReplyDto> listReply(Criteria criteria, int articleId) throws Exception {
		return this.replyDao.listReply(criteria, articleId);
	}

	@Override
	public int countReply(int articleId) throws Exception {
		return this.replyDao.countReply(articleId);
	}

	@Override
	public int insertReply(ReplyDto replyDto) throws Exception {
		return this.replyDao.insertReply(replyDto);
	}

	@Override
	public int updateReply(ReplyDto replyDto) throws Exception {
		return this.replyDao.updateReply(replyDto);
	}

	@Override
	public int deleteReply(int reply_id) throws Exception {
		return this.replyDao.deleteReply(reply_id);
	}
}