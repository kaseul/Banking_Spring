package aca.mirim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import aca.mirim.domain.AccountVO;
import aca.mirim.service.AccountService;
import aca.mirim.service.BankService;
import aca.mirim.service.UserService;

@Controller
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public String account_get(Model model, HttpSession session) {
		System.out.println("account get,,,,,,");
		
		List<AccountVO> accounts = accountService.getUserAccounts((String)session.getAttribute("login"));
		
		if(accounts.size() < 1) {
			model.addAttribute("accounts", "null");
		}
		else {
			model.addAttribute("accounts", accounts);
		}
		
		return "/account/account";
	}
	
	@GetMapping("/account/register")
	public void acctRegister_get(Model model, HttpSession session) {
		System.out.println("account register get,,,,,,,,,,");
		
		model.addAttribute("user", userService.getUser((String)session.getAttribute("login")));
		model.addAttribute("banks", bankService.getBanks());
	}
	
	@PostMapping("/account/register")
	public String acctRegister_post(AccountVO account) {
		System.out.println("account register post,,,,,,,,,,");
		
		accountService.register(account);
		
		return "redirect:/account";
	}
	
}
