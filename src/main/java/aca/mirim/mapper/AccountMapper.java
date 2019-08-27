package aca.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import aca.mirim.domain.AccountVO;

public interface AccountMapper {
	
	@Select("SELECT * FROM accountTbl")
	public List<AccountVO> getAccounts();
	
	@Select("SELECT * FROM accountTbl WHERE aid = #{aid}")
	public AccountVO getAccount(String aid);
	
	@Select("SELECT * FROM accountTbl WHERE id = #{id}")
	public List<AccountVO> getUserAccounts(String id);
	
	@Insert("INSERT INTO accountTbl VALUES(#{aid}, #{id}, #{bcode}, #{balance})")
	public void insertAccount(AccountVO account);
	
	@Update("Update accountTbl SET balance = #{balance} WHERE aid = #{aid}")
	public void updateAccount(AccountVO account);
	
}
