package aca.mirim.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aca.mirim.domain.LoginDTO;
import aca.mirim.domain.UserVO;
import aca.mirim.mapper.UserMapper;
import aca.mirim.service.UserService;
import oracle.jdbc.proxy.annotation.Post;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		 * logger.info("Welcome home! The client locale is {}.", locale);
		 * 
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 * 
		 * return "home";
		 */
		
		return "index";
	}
	
	@GetMapping("/login")
	public void login_get() {
		System.out.println("login get,,,,,,,,");
	}
	
	@PostMapping("/login")
	public String login_post(Model model, LoginDTO login, HttpSession session) {
		System.out.println("login post,,,,,,,,,,");
		
		UserVO user = userService.login(login);
		
		if(user == null) {
			
			return "redirect:/login";
		}
		
		session.setAttribute("login", user);
		
		return "redirect:/main";
	}
	
	@GetMapping("/join")
	public void join_get(Model model) {
		System.out.println("join get,,,,,,,,,");
		
		model.addAttribute("users", userService.getUserList());
	}
	
	@PostMapping("/join")
	public String join_post(UserVO user) {
		System.out.println("join post,,,,,,,,,,,");
		
		System.out.println(user);
		userService.register(user);
		
		return "redirect:/login";
	}
	
	
}
