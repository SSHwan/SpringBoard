package com.seunghwan.springBoard.utility.interceptor;

import com.seunghwan.springBoard.user.dto.UserDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminAuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		UserDto userDto = (UserDto) httpSession.getAttribute("user");
		if (userDto == null) {
			logger.info("로그인이 필요합니다.");
			response.sendRedirect(request.getContextPath());
			return false;
		} else if (userDto.getUser_id().equals("admin")) {
			return true;
		} else {
			logger.info("관리자만 접근할 수 있습니다.");
			response.sendRedirect(request.getContextPath());
			return false;
		}
	}
}