package aca.mirim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aca.mirim.domain.RemitJoinVO;
import aca.mirim.domain.TransactionCountVO;
import aca.mirim.mapper.TransactionMapper;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionMapper tranMapper;

	@Override
	public List<TransactionCountVO> getTransactionMonthsCount(String outaid, String startDay) {
		return tranMapper.getTransactionMonthsCount(outaid, startDay);
	}

	@Override
	public List<RemitJoinVO> getTransactions(String aid, String startDay, String endDay) {
		return tranMapper.getTransactions(aid, startDay, endDay);
	}

}
