package com.seunghwan.springBoard.reply.controller;

import com.seunghwan.springBoard.reply.dto.ReplyDto;
import com.seunghwan.springBoard.reply.service.ReplyService;
import com.seunghwan.springBoard.utility.page.Criteria;
import com.seunghwan.springBoard.utility.page.PageDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/reply"})
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	private final ReplyService replyService;

	@Inject
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	@GetMapping(value = {"/replyList/{article_id}/{page}"}, produces = {"application/xml",
			"application/json;charset=UTF-8"})
	public ResponseEntity<Map<String, Object>> replyList(@PathVariable("page") int page,
			@PathVariable("article_id") int article_id) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		logger.info("get replyList!");
		Criteria criteria = new Criteria(page, 20);
		logger.info("criteria: " + criteria);
		List<ReplyDto> replies = this.replyService.listReply(criteria, article_id);
		int totalReply = this.replyService.countReply(article_id);
		PageDto pageMaker = new PageDto(criteria, totalReply, 5);
		Map<String, Object> map = new HashMap();
		map.put("list", replies);
		map.put("pageMaker", pageMaker);
		entity = new ResponseEntity(map, HttpStatus.OK);
		return entity;
	}

	@PostMapping(value = {"/newReply"}, consumes = {"application/json"}, produces = {"text/plain"})
	public ResponseEntity<String> newReply(@RequestBody ReplyDto replyDto) throws Exception {
		logger.info("newReply : " + replyDto);
		int insertCount = this.replyService.insertReply(replyDto);
		logger.info("insertCount : " + insertCount);
		return insertCount == 1
				? new ResponseEntity("success", HttpStatus.OK)
				: new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping(value = {"/{reply_id}"}, produces = {"text/plain"})
	public ResponseEntity<String> deleteReply(@PathVariable("reply_id") int reply_id) throws Exception {
		logger.info("delete reply : " + reply_id);
		return this.replyService.deleteReply(reply_id) == 1
				? new ResponseEntity("success", HttpStatus.OK)
				: new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = {"/{reply_id}"}, method = {RequestMethod.PUT, RequestMethod.PATCH}, consumes = {
			"application/json"}, produces = {"text/plain"})
	public ResponseEntity<String> updateReply(@RequestBody ReplyDto replyDto, @PathVariable("reply_id") int reply_id)
			throws Exception {
		logger.info("update reply : " + reply_id);
		logger.info(replyDto.toString());
		replyDto.setReply_id(reply_id);
		return this.replyService.updateReply(replyDto) == 1
				? new ResponseEntity("success", HttpStatus.OK)
				: new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}