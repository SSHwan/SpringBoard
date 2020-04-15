package com.seunghwan.springBoard.user.controller;

import com.seunghwan.springBoard.user.dto.LoginDto;
import com.seunghwan.springBoard.user.dto.UserDto;
import com.seunghwan.springBoard.user.service.UserService;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/user"})
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;
	private UserDto userDto;

	@Inject
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping({"/loginForm"})
	public String loginFrom() throws Exception {
		logger.info("loginForm!");
		return "user/loginForm";
	}

	@RequestMapping({"/joinForm"})
	public String joinForm() throws Exception {
		logger.info("joinForm!");
		return "user/joinForm";
	}

	@RequestMapping(value = {"/join"}, method = {RequestMethod.POST})
	public String join(@ModelAttribute @Valid UserDto userDto, BindingResult result,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.info("user join!");
		if (!result.hasErrors()) {
			String hashed_user_pw = BCrypt.hashpw(userDto.getUser_pw(), BCrypt.gensalt());
			userDto.setUser_pw(hashed_user_pw);
			System.out.println(userDto);
			this.userService.joinUser(userDto);
			logger.info("joinUser success!");
			redirectAttributes.addFlashAttribute("msg", "joinSuccess");
			return "redirect:/";
		} else {
			List<ObjectError> list = result.getAllErrors();
			Iterator var6 = list.iterator();

			while (var6.hasNext()) {
				ObjectError error = (ObjectError) var6.next();
				System.out.println(error);
			}

			return "/user/joinForm";
		}
	}

	@RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
	public void login(LoginDto loginDto, HttpSession httpSession, Model model) throws Exception {
		logger.info("user login!");
		this.userDto = this.userService.login(loginDto);
		if (this.userDto != null && BCrypt.checkpw(loginDto.getUser_pw(), this.userDto.getUser_pw())) {
			this.userService.updateLoginDate(this.userDto);
			model.addAttribute("user", this.userDto);
		}
	}

	@RequestMapping({"/logout"})
	public String logout(HttpSession httpSession) throws Exception {
		logger.info("user logout!");
		httpSession.invalidate();
		return "redirect:/";
	}

	@RequestMapping({"/userIdCheck"})
	@ResponseBody
	public int userIdCheck(@RequestParam String user_id) throws Exception {
		logger.info("user id check!");
		System.out.println(user_id);
		if (user_id == "") {
			int result = -1;
			return result;
		} else {
			int result = this.userService.userIdCheck(user_id);
			System.out.println(result);
			return result;
		}
	}
}