package com.spring.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping("home")
	public String home(Model model) {
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
	public String loginOk(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		System.out.println("login()");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("loginOK: "+ id);
		model.addAttribute("request", request);

		int ck = userService.loginUser(model);
		System.out.println(ck);
		if(id.equals("1") && pw.equals("1")) {
			session.setAttribute("id", id);
			response.setContentType("text/html;??charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('ADMIN login');??</script>");
			out.flush();
			return admin(model);
		}
		
		if (ck != 0) {
			System.out.println("ok");
			session.setAttribute("id", id);
			System.out.println("????????????O");
			return "updatePage";
		} else {
			System.out.println("no");
			response.setContentType("text/html;??charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('Unable login');??</script>");
			out.flush();
			return "home";
		}

	}
	
	@RequestMapping("sign_up_ok")
	public String joinOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		System.out.println("sign_up_ok()");
		model.addAttribute("request", request);
		userService.insertUser(model);
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('sign_up Success');??</script>");
		out.flush();
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
	
	@RequestMapping("updatePage")
	public String updatePage(Model model) {
		return "updatePage";
	}
	
	@RequestMapping("updateName")
	public String updateName(Model model) {
		return "updateName";
	}
	
	@RequestMapping("updateNumber")
	public String updateNumber(Model model) {
		return "updateNumber";
	}
	
	@RequestMapping("updatePw")
	public String updatePw(Model model) {
		return "updatePw";
	}
	
	@RequestMapping("updatePwOk")
	@ResponseBody 
	public String updatePwOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		System.out.println("update_pwOk()");
		model.addAttribute("request", request);
		userService.updatePw(model); 
		session.invalidate();
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return "home";
	}
	
	@RequestMapping("AupdatePwOk")
	public String AupdatePwOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		System.out.println("AupdateNumberOk()");
		model.addAttribute("request", request);
		userService.updatePw(model); 
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return admin(model);	
	}

	
	@RequestMapping("deleteUser.do")
	public String deleteUser(@RequestParam String id,HttpServletResponse response,HttpSession session) throws IOException {
		userService.delete(id);
		session.invalidate();
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Delete Success');??</script>");
		out.flush();
		return "home";
	}
	
	@RequestMapping("AdeleteUser.do")
	public String AdeleteUser(@RequestParam String id,Model model,HttpServletResponse response) throws IOException {
		userService.delete(id);
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return admin(model);
	}
	
	@RequestMapping("myInformation.do")
	public String myInformation(@RequestParam String id, Model model) {
		userService.information(id);
		List<UserDTO> information = userService.information(id);
		model.addAttribute("information", information);
		return "myInformatoin";
	}
	
	@RequestMapping("updateNameOk")
	public String updateNameOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		System.out.println("updateNameOk()");
		model.addAttribute("request", request);
		userService.updateNameOk(model);
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return "updatePage";	
	}
	
	@RequestMapping("AupdateNameOk")
	public String AupdateNameOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		System.out.println("updateNameOk()");
		model.addAttribute("request", request);
		userService.updateNameOk(model);
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return admin(model);	
	}
	
	@RequestMapping("updateNumberOk")
	public String updateNumberOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		System.out.println("updateNumberOk()");
		model.addAttribute("request", request);
		userService.updateNumberOk(model);
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return "updatePage";	
	}
	
	@RequestMapping("AupdateNumberOk")
	public String AupdateNumberOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		System.out.println("AupdateNumberOk()");
		model.addAttribute("request", request);
		userService.updateNumberOk(model);
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return admin(model);
	}
	
	@RequestMapping("admin")
	public String admin(Model model) {
		List<UserDTO> userlist = userService.userlist(); 
		model.addAttribute("userlist", userlist); 
		return "admin/admin";
	}
	
	@RequestMapping("manageUser.do")
	public String manageUser(@RequestParam String id,Model model) {
		userService.information(id);
		List<UserDTO> manageUser = userService.information(id);
		model.addAttribute("manageUser", manageUser);
		return "admin/manageUser";
	}
	
	@RequestMapping("approveOk")
	public String approveOk(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		System.out.println("approveOk()");
		model.addAttribute("request", request);
		userService.approve(model);
		response.setContentType("text/html;??charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Update Complete');??</script>");
		out.flush();
		return admin(model);
	}
	
}
