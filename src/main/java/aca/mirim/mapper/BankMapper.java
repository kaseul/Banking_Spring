package aca.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import aca.mirim.domain.BankVO;

public interface BankMapper {

	@Select("SELECT * FROM bankTbl")
	public List<BankVO> getBanks();
	
	@Select("SELECT * FROM bankTbl WHERE bcode = #{bcode}")
	public BankVO getBank(String bcode);
	
}
