package aca.mirim.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aca.mirim.domain.AccountJoinVO;
import aca.mirim.mapper.AccountMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AccountTest {

	@Autowired
	private AccountMapper accountMapper;
	
	@Test
	public void getUserAccountJoinTest() {
		System.out.println("Test Join getUserAccount,,,,,,,");
		
		List<AccountJoinVO> accounts = accountMapper.getUserAccountJoins("ddd");
		
		for(AccountJoinVO account : accounts) {
			System.out.println(account);
		}
	}
	
	@Test
	public void deleteAccountTest() {
		System.out.println("Test deleteAccount,,,,,,,,,,");
		
		accountMapper.deleteAccount("ddd");
	}
}
