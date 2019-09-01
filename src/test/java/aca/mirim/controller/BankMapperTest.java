package aca.mirim.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aca.mirim.domain.BankVO;
import aca.mirim.mapper.BankMapper;
import aca.mirim.service.BankService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BankMapperTest {
	
	@Autowired
	private BankMapper bankMapper;
	
	@Autowired
	private BankService bankService;
	
	@Test
	public void getBankListTest() {
		System.out.println("Test getBanks,,,,,,");
		
		List<BankVO> banks = bankMapper.getBanks();
		
		for(BankVO bank : banks) {
			System.out.println(bank);
		}
	}
	
	@Test
	public void getBanksServiceTest() {
		System.out.println("Test Service getBanks,,,,,,,,");
		
		List<BankVO> banks = bankService.getBanks();
		
		for(BankVO bank : banks) {
			System.out.println(bank);
		}
	}

}
