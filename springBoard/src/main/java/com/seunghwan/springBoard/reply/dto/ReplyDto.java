package com.seunghwan.springBoard.reply.dto;

import java.sql.Timestamp;

public class ReplyDto {
	private int reply_id;
	private int article_id;
	private String reply_content;
	private String user_id;
	private String user_name;
	private Timestamp reg_date;
	private Timestamp update_date;

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getReply_id() {
		return this.reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public int getArticle_id() {
		return this.article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getReply_content() {
		return this.reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Timestamp getReg_date() {
		return this.reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public Timestamp getUpdate_date() {
		return this.update_date;
	}

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "ReplyDto [reply_id=" + this.reply_id + ", article_id=" + this.article_id + ", reply_content="
				+ this.reply_content + ", user_id=" + this.user_id + ", user_name=" + this.user_name + ", reg_date="
				+ this.reg_date + ", update_date=" + this.update_date + "]";
	}
}