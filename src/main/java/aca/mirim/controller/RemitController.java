package aca.mirim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String remit_post(RemitVO remit, String inaid, String inbcode) {
		System.out.println("remit post,,,,,,,,,,,,,,,,");
		System.out.println(remit + " : " + inaid + " : " + inbcode);
		
		if(accountService.getAccountWithBank(inaid, inbcode) == null) {
			return "redirect:/remit?result=fail";
		}
		else {
			if(remit.getOutaid().equals(inaid)) {
				remit.setCommission(0);
			}
			remitService.remit(remit);
		}
		
		return "redirect:/remit/success";
	}
	
	@GetMapping("/remit/success")
	public void remit_success_get() {
		System.out.println("remit success get,,,,,,,,,,,,,,,,");
	}
	
}
