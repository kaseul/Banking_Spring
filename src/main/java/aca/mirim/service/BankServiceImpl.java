package aca.mirim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aca.mirim.domain.BankVO;
import aca.mirim.mapper.BankMapper;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankMapper bankMapper;
	
	@Override
	public List<BankVO> getBanks() {
		return bankMapper.getBanks();
	}

	@Override
	public BankVO getBank(String bcode) {
		return bankMapper.getBank(bcode);
	}

}
