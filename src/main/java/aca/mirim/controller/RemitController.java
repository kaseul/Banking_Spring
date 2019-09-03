package aca.mirim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import aca.mirim.service.RemitService;

public class RemitController {
	
	@Autowired
	private RemitService remitService;
	
	@GetMapping("/remit")
	public String remit_get() {
		System.out.println("remit get,,,,,,,,,,,");
		
		return "/remit/account";
	}
}
