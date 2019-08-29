package aca.mirim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aca.mirim.domain.AccountVO;
import aca.mirim.service.AccountService;
import aca.mirim.service.BankService;
import aca.mirim.service.UserService;

@Controller
public class AccountController {
	
	@Autowired
	private UserService userService;
	private BankService bankService;
	private AccountService accountService;
	
	@GetMapping("/account")
	public String account_get(Model model, HttpSession session) {
		System.out.println("account get,,,,,,");
		System.out.println((String)session.getAttribute("login"));
		
		List<AccountVO> accounts = null;
		
		try {
			accounts = accountService.getUserAccounts((String)session.getAttribute("login"));
		} catch (Exception e) {
			accounts = null;
		}
		
		if(accounts == null) {
			model.addAttribute("accounts", "null");
		}
		else {
			model.addAttribute("accounts", accounts);
		}
		
		
		return "/account/account";
	}
	
	@GetMapping("/account/register")
	public void acctRegsiter_get(Model model, HttpSession session) {
		System.out.println("account register get,,,,,,,,,,");
		
		model.addAttribute("user", userService.getUser((String)session.getAttribute("login")));
		model.addAttribute("banks", bankService.getBanks());
	}
	
}
