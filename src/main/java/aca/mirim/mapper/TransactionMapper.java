package aca.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import aca.mirim.domain.TransactionCountVO;

public interface TransactionMapper {
	
	@Select("SELECT fnMonth(remit_date) month, COUNT(*) count FROM remitTbl WHERE outaid = #{outaid} AND remit_date >= #{startDay} GROUP BY fnMonth(remit_date) ORDER BY month")
	public List<TransactionCountVO> getTransactionMonthsCount(@Param("outaid") String outaid, @Param("startDay") String startDay);
	
}
