package aca.mirim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aca.mirim.domain.AccountJoinVO;
import aca.mirim.domain.AccountVO;
import aca.mirim.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public List<AccountVO> getAccounts() {
		return accountMapper.getAccounts();
	}

	@Override
	public AccountVO getAccount(String aid) {
		return accountMapper.getAccount(aid);
	}

	@Override
	public List<AccountVO> getUserAccounts(String id) {
		return accountMapper.getUserAccounts(id);
	}
	
	@Override
	public AccountVO getAccountWithBank(String aid, String bcode) {
		return accountMapper.getAccountWithBank(aid, bcode);
	}

	@Override
	public void register(AccountVO account) {
		accountMapper.insertAccount(account);
	}

	@Override
	public void modify(AccountVO account) {
		accountMapper.updateAccount(account);
	}

	@Override
	public List<AccountJoinVO> getUserAccountJoins(String id) {
		return accountMapper.getUserAccountJoins(id);
	}

	@Override
	public AccountJoinVO getAccountJoin(String aid) {
		return accountMapper.getAccountJoin(aid);
	}
	
}
