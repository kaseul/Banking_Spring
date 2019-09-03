package aca.mirim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import aca.mirim.domain.RemitVO;
import aca.mirim.mapper.RemitMapper;

public class RemitServiceImpl implements RemitService {
	
	@Autowired
	private RemitMapper remitMapper;

	@Override
	public List<RemitVO> getRemitList() {
		return remitMapper.getRemitList();
	}

	@Override
	public void remit(RemitVO remit) {
		remitMapper.insertRemit(remit);
	}
	
}
