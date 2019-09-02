package aca.mirim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aca.mirim.domain.AccountJoinVO;
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
	public String account_get(@RequestParam(required=false, defaultValue="null") String result, Model model, HttpSession session) {
		System.out.println("account get,,,,,,");
		
		List<AccountJoinVO> accounts = accountService.getUserAccountJoins((String)session.getAttribute("login"));
		
		if(accounts.size() < 1) {
			model.addAttribute("accounts", "null");
		}
		else {
			model.addAttribute("accounts", accounts);
		}
		
		model.addAttribute("result", result);
		
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
		
		return "redirect:/account?result=resister";
	}
	
	@GetMapping("/account/modify")
	public void acctModify_get(@RequestParam String aid, Model model, HttpSession session) {
		System.out.println("account modify get,,,,,,,,,,,,,");
		
		model.addAttribute("account", accountService.getAccountJoin(aid));
	}
	
	@PostMapping("/account/modify")
	public String acctModify_post(AccountVO account) {
		System.out.println("account modify post,,,,,,,,,,,,,");
		
		accountService.modify(account);
		
		return "redirect:/account?result=modify";
	}
	
}
