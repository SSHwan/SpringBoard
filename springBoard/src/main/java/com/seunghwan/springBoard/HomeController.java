package com.seunghwan.springBoard;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = {"/"}, method = {RequestMethod.GET})
	public String home(Locale locale, Model model, HttpSession session, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		Object destination = session.getAttribute("destination");
		if (destination != null) {
			request.getSession().setAttribute("destination", (Object) null);
		}

		return "home";
	}

	@RequestMapping({"/userPage"})
	public String userPage() {
		logger.info("userPage!");
		return "userPage";
	}

	@RequestMapping({"/adminPage"})
	public String adminPage() {
		logger.info("adminPage!");
		return "adminPage";
	}
}