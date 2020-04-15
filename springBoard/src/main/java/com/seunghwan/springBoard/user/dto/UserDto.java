package com.seunghwan.springBoard.user.dto;

import java.sql.Timestamp;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserDto {
	@NotEmpty
	@Pattern(regexp = "^[0-9a-zA-Z]{4,15}$")
	private String user_id;
	@NotEmpty
	@Pattern(regexp = "^[0-9a-zA-Z]{4,20}$")
	private String user_pw;
	@NotEmpty
	@Length(min = 2, max = 5)
	private String user_name;
	@NotEmpty
	@Email
	private String user_email;
	private int user_point;
	private String user_img;
	private Timestamp user_join_date;
	private Timestamp user_login_date;
	private boolean user_enabled;
	private String user_authority;

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return this.user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return this.user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_point() {
		return this.user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	public String getUser_img() {
		return this.user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public Timestamp getUser_join_date() {
		return this.user_join_date;
	}

	public void setUser_join_date(Timestamp user_join_date) {
		this.user_join_date = user_join_date;
	}

	public Timestamp getUser_login_date() {
		return this.user_login_date;
	}

	public void setUser_login_date(Timestamp user_login_date) {
		this.user_login_date = user_login_date;
	}

	public boolean isUser_enabled() {
		return this.user_enabled;
	}

	public void setUser_enabled(boolean user_enabled) {
		this.user_enabled = user_enabled;
	}

	public String getUser_authority() {
		return this.user_authority;
	}

	public void setUser_authority(String user_authority) {
		this.user_authority = user_authority;
	}

	@Override
	public String toString() {
		return "UserDto [user_id=" + this.user_id + ", user_pw=" + this.user_pw + ", user_name=" + this.user_name
				+ ", user_email=" + this.user_email + ", user_point=" + this.user_point + ", user_img=" + this.user_img
				+ ", user_join_date=" + this.user_join_date + ", user_login_date=" + this.user_login_date
				+ ", user_enabled=" + this.user_enabled + ", user_authority=" + this.user_authority + "]";
	}
}