package aca.mirim.service;

import java.util.List;

import aca.mirim.domain.RemitVO;

public interface RemitService {
	
	public List<RemitVO> getRemitList();
	public void remit(RemitVO remit);
	
}
