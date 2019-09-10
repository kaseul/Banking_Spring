package aca.mirim.controller;

import java.util.Calendar;
import java.util.List;

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
import aca.mirim.domain.TransactionCountVO;
import aca.mirim.service.AccountService;
import aca.mirim.service.BankService;
import aca.mirim.service.RemitService;
import aca.mirim.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RemitService remitService;
	
	@Autowired
	private TransactionService tranService;
	
	@GetMapping("/transaction")
	public String transaction_get(Model model, HttpSession session) {
		System.out.println("transaction get,,,,,,,,,,,");
		
		model.addAttribute("accounts", accountService.getUserAccountJoins((String)session.getAttribute("login")));
		
		return "/transaction/account";
	}
	
	@GetMapping("/transaction/inquiry")
	public String transaction_inquiry_get(@RequestParam String outaid, Model model) {
		System.out.println("transaction inquiry get,,,,,,,,,,,");
		
		Calendar cal = Calendar.getInstance();
		String startDay = cal.get(Calendar.YEAR) + "/" + String.format("%02d", (cal.get(Calendar.MONTH) + 1) - 5) + "/01";
		
		model.addAttribute("transactions", tranService.getTransactionMonthsCount(outaid, startDay));
		
		return "/transaction/transaction";
	}
	
	@PostMapping("/transaction/")
	public String transaction_post(RemitVO remit, BankVO outbank, String inaid, String inbcode, Model model) {
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
	
}
