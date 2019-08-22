package aca.mirim.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aca.mirim.domain.LoginDTO;
import aca.mirim.domain.UserVO;
import aca.mirim.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	public void login_get(@RequestParam(required=false) String result, Model model) {
		System.out.println("login get,,,,,,,,");
		
		if(result == null) {
			model.addAttribute("result", "null");
		}
		else {
			System.out.println(result);
			model.addAttribute("result", result);
		}
	}
	
	@PostMapping("/login")
	public String login_post(Model model, LoginDTO login, HttpSession session) {
		System.out.println("login post,,,,,,,,,,");
		
		UserVO user = userService.login(login);
		
		if(user == null) {
			model.addAttribute("result", "fail");
			return "redirect:/login";
		}
		
		session.setAttribute("login", user.getId());
		
		return "redirect:/user";
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
	
	@GetMapping("/user")
	public void user_get(Model model, HttpSession session) {
		System.out.println("user get,,,,,,,,,,,");
		
		model.addAttribute("user", userService.getUser((String)session.getAttribute("login")));
	}
	
}
