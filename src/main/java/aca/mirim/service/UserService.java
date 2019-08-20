package aca.mirim.service;

import java.util.List;

import aca.mirim.domain.UserVO;

public interface UserService {
	
	public List<UserVO> getUserList();
	public UserVO getUser(String id);
	public void register(UserVO user);
	public void modify(UserVO user);
	public void remove(String id);
	
}
