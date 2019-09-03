package aca.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import aca.mirim.domain.RemitVO;

public interface RemitMapper {
	
	@Select("SELECT * FROM remitTbl")
	public List<RemitVO> getRemitList();
	
	@Insert("INSERT INTO remitTbl(outaid, inaid, price) VALUES(#{outaid}, #{inaid}, #{price})")
	public void insertRemit(RemitVO remit);
	
}
