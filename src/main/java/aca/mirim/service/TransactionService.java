package aca.mirim.service;

import java.util.List;

import aca.mirim.domain.RemitJoinVO;
import aca.mirim.domain.TransactionCountVO;

public interface TransactionService {
	
	public List<TransactionCountVO> getTransactionMonthsCount(String outaid, String startDay);
	public List<RemitJoinVO> getTransactions(String aid, String startDay, String endDay);
	
}
