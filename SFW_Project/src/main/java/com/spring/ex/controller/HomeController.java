package com.spring.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ex.dto.UserDTO;
import com.spring.ex.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	UserService userService;

	
	private static final Logger logger =
	 LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("sign_up")
	public String sign_up(Model model) {
		return "sign_up";
	}
	
	@RequestMapping("loginok")
	public String loginOk(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		System.out.println("login()");
		String id = request.getParameter("id");
		System.out.println("loginOK: "+ id);
		
		List<UserDTO> userlist = userService.findname(id);
		
		model.addAttribute("request", request);
		model.addAttribute("userlist", userlist);

		int ck = userService.loginUser(model);
		System.out.println(ck);
		if (ck != 0) {
			System.out.println("ok");
			session.setAttribute("id", id);
			System.out.println("세션설정O");
			return "loginok";
		} else {
			System.out.println("no");
			return "home";
		}

	}
	
	@RequestMapping("sign_up_ok")
	public String joinOk(HttpServletRequest request, Model model) {
		System.out.println("sign_up_ok()");
		model.addAttribute("request", request);
		userService.insertUser(model);
		return "home";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session, Model model) {
		System.out.println("logout()");
		session.invalidate();
		return "home";
	}
	
	@RequestMapping("idCk")
	@ResponseBody 
	public int idcheck(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String id) {
	    System.out.println("asdfasdfsa");

	    int result = userService.idCk(req.getParameter("id"));
	    System.out.println(result);
	    return result; 
	}
}
