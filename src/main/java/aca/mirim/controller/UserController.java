package aca.mirim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import aca.mirim.domain.UserVO;
import aca.mirim.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/register")
	public void register() {
		System.out.println("user register,,,,,,,,,");
	}
	
	@PostMapping("/user/register")
	public String register(UserVO vo) {
		System.out.println("user register post,,,,,,,,,,,,,,,");
		
		userService.register(vo);
		
		return "redirect:/login";
	}
	
	@GetMapping("/user/modify")
	public void modify_get(Model model, HttpSession session) {
		System.out.println("modify get,,,,,,,");
		
		model.addAttribute("user", userService.getUser((String)session.getAttribute("login")));
	}
	
	@PostMapping("/user/modify")
	public String modify_post(UserVO user, Model model) {
		userService.modify(user);
		
		return "redirect:/user";
	}
	
	@GetMapping("/user/remove")
	public String remove(HttpSession session) {
		
		userService.remove((String)session.getAttribute("login"));
		session.removeAttribute("login");
		
		return "redirect:/";
	}
	
}
