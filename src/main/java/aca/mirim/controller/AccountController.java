package aca.mirim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aca.mirim.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public String account_get(Model model, HttpSession session) {
		System.out.println("account get,,,,,,");
		
		model.addAttribute("accounts", accountService.getUserAccounts((String)session.getAttribute("login")));
		
		return "/account/account";
	}
	
}
