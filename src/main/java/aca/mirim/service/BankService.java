package aca.mirim.service;

import java.util.List;

import aca.mirim.domain.BankVO;

public interface BankService {
	
	public List<BankVO> getBanks();
	public BankVO getBank(String bcode);
	
}
