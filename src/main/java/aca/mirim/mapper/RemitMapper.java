package aca.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import aca.mirim.domain.RemitVO;

public interface RemitMapper {
	
	@Select("SELECT * FROM remitTbl")
	public List<RemitVO> getRemitList();
	
	@Insert("INSERT INTO remitTbl(no, outaid, inaid, price, commission) VALUES(noseq.NEXTVAL, #{outaid}, #{inaid}, #{price}, #{commission})")
	public void insertRemit(RemitVO remit);
	
}
