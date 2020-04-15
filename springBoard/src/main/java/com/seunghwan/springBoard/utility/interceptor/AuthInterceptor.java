package com.seunghwan.springBoard.utility.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("user") == null) {
			logger.info("current user is not logged");
			this.saveDestination(request);
			response.sendRedirect(request.getContextPath() + "/user/loginForm");
			return false;
		} else {
			return true;
		}
	}

	private void saveDestination(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		if (query != null && !query.equals("null")) {
			query = "?" + query;
		} else {
			query = "";
		}

		if (request.getMethod().equals("GET")) {
			logger.info("destination : " + uri + query);
			request.getSession().setAttribute("destination", uri + query);
		}

	}
}