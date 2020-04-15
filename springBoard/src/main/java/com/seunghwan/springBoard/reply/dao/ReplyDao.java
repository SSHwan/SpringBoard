package com.seunghwan.springBoard.reply.dao;

import com.seunghwan.springBoard.reply.dto.ReplyDto;
import com.seunghwan.springBoard.utility.page.Criteria;
import java.util.List;

public interface ReplyDao {
	List<ReplyDto> listReply(Criteria var1, int var2) throws Exception;

	int countReply(int var1) throws Exception;

	int insertReply(ReplyDto var1) throws Exception;

	int updateReply(ReplyDto var1) throws Exception;

	int deleteReply(int var1) throws Exception;
}