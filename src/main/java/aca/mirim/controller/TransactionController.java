package aca.mirim.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	private AccountService accountService;
	
	@Autowired
	private TransactionService tranService;
	
	@GetMapping("/transaction")
	public String transaction_get(Model model, HttpSession session) {
		System.out.println("transaction get,,,,,,,,,,,");
		
		model.addAttribute("accounts", accountService.getUserAccountJoins((String)session.getAttribute("login")));
		
		return "/transaction/account";
	}
	
	@GetMapping("/transaction/inquiry")
	public String transaction_inquiry_get(@RequestParam String outaid, @RequestParam(required=false, defaultValue="0") int month, Model model) {
		System.out.println("transaction inquiry get,,,,,,,,,,,");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String startDay = cal.get(Calendar.YEAR) + "/" + String.format("%02d", (cal.get(Calendar.MONTH) + 1) - 5) + "/01";
		System.out.println("month : " + cal.get(Calendar.MONTH));
		
		cal.add(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1);
		String todayMonth = format.format(cal.getTime());
		cal.add(Calendar.MONTH, 1);
		String nextMonth = format.format(cal.getTime());
		
		System.out.println("todayMonth : " + todayMonth + ", nextMonth : " + nextMonth);
		
		model.addAttribute("date", new Date());
		model.addAttribute("month", month);
		model.addAttribute("transactions", tranService.getTransactionMonthsCount(outaid, startDay));
		model.addAttribute("transactionList", tranService.getTransactions(outaid, todayMonth, nextMonth));
		model.addAttribute("account", accountService.getAccount(outaid));
		
		return "/transaction/transaction";
	}
	
}
