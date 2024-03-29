package aca.mirim.service;

import java.util.List;

import aca.mirim.domain.AccountJoinVO;
import aca.mirim.domain.AccountRemitJoinVO;
import aca.mirim.domain.AccountVO;

public interface AccountService {
	
	public List<AccountVO> getAccounts();
	public AccountVO getAccount(String aid);
	public List<AccountVO> getUserAccounts(String id);
	public AccountJoinVO getAccountWithBank(String aid, String bcode);
	public void register(AccountVO account);
	public void modify(AccountVO account);
	public List<AccountJoinVO> getUserAccountJoins(String id);
	public AccountJoinVO getAccountJoin(String aid);
	public List<AccountRemitJoinVO> getAccountRemitFav(String outaid);
	public List<AccountRemitJoinVO> getAccountRemitRecent(String outaid);
	
}
