package aca.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import aca.mirim.domain.AccountJoinVO;
import aca.mirim.domain.AccountVO;

public interface AccountMapper {
	
	@Select("SELECT * FROM accountTbl")
	public List<AccountVO> getAccounts();
	
	@Select("SELECT * FROM accountTbl WHERE aid = #{aid}")
	public AccountVO getAccount(String aid);
	
	@Select("SELECT * FROM accountTbl WHERE id = #{id}")
	public List<AccountVO> getUserAccounts(String id);
	
	@Select("SELECT a.aid, u.uname, b.bcode, b.bname, a.balance FROM accountTbl a, userTbl u, bankTbl b WHERE a.aid = #{aid} AND a.bcode = #{bcode} AND a.id = u.id AND a.bcode = b.bcode")
	public AccountJoinVO getAccountWithBank(@Param("aid") String aid, @Param("bcode") String bcode);
	
	@Insert("INSERT INTO accountTbl VALUES(#{aid}, #{id}, #{bcode}, #{balance})")
	public void insertAccount(AccountVO account);
	
	@Update("UPDATE accountTbl SET balance = #{balance} WHERE aid = #{aid}")
	public void updateAccount(AccountVO account);
	
	@Delete("DELETE FROM accountTbl WHERE aid = #{aid}")
	public void deleteAccount(String aid);
	
	// 계좌 조회
	@Select("SELECT a.aid, u.uname, b.bcode, b.bname, a.balance FROM accountTbl a, userTbl u, bankTbl b WHERE a.id = #{id} AND a.id = u.id AND a.bcode = b.bcode")
	public List<AccountJoinVO> getUserAccountJoins(String id);
	
	@Select("SELECT a.aid, u.uname, b.bcode, b.bname, a.balance FROM accountTbl a, userTbl u, bankTbl b WHERE a.aid = #{aid} AND a.id = u.id AND a.bcode = b.bcode")
	public AccountJoinVO getAccountJoin(String aid);
	
}
