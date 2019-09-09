package aca.mirim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aca.mirim.domain.AccountJoinVO;
import aca.mirim.domain.BankVO;
import aca.mirim.domain.RemitVO;
import aca.mirim.service.AccountService;
import aca.mirim.service.BankService;
import aca.mirim.service.RemitService;

@Controller
public class RemitController {
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RemitService remitService;
	
	@GetMapping("/remit")
	public String remit_get(@RequestParam(required=false, defaultValue="null") String result, Model model, HttpSession session) {
		System.out.println("remit get,,,,,,,,,,,");
		
		model.addAttribute("result", result);
		model.addAttribute("banks", bankService.getBanks());
		model.addAttribute("accounts", accountService.getUserAccountJoins((String)session.getAttribute("login")));
		
		return "/remit/register";
	}
	
	@PostMapping("/remit/register")
	public String remit_post(RemitVO remit, BankVO outbank, String inaid, String inbcode, Model model) {
		System.out.println("remit post,,,,,,,,,,,,,,,,");
		System.out.println(remit + " : " + inaid + " : " + inbcode);
		
		AccountJoinVO inAccount = accountService.getAccountWithBank(inaid, inbcode); 
		
		if(inAccount == null) {
			return "redirect:/remit?result=fail";
		}
		else {
			if(remit.getOutaid().equals(inaid)) {
				remit.setCommission(0);
			}
			model.addAttribute("remit", remit);
			model.addAttribute("outbank", outbank);
			model.addAttribute("inAccount", inAccount);

			return "/remit/check";
		}
	}
	
	@GetMapping("/remit/check")
	public void remit_check_get() {
		System.out.println("remit check get,,,,,,,,,,,,");
	}
	
	@PostMapping("/remit/check")
	public String remit_check_post(RemitVO remit) {
		System.out.println("remit check post,,,,,,,,,,,,");
		System.out.println(remit);
		
		remitService.remit(remit);
		
		return "redirect:/remit/success";
	}
	
	@GetMapping("/remit/success")
	public void remit_success_get() {
		System.out.println("remit success get,,,,,,,,,,,,,,,,");
	}
	
}
