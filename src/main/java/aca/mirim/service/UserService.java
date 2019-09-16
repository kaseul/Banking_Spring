package aca.mirim.service;

import java.util.List;

import aca.mirim.domain.DataVO;
import aca.mirim.domain.LoginDTO;
import aca.mirim.domain.UserVO;

public interface UserService {
	
	public List<UserVO> getUserList();
	public UserVO getUser(String id);
	public void register(UserVO user);
	public void modify(UserVO user);
	public void remove(String id);
	public UserVO login(LoginDTO login);
	public List<DataVO> getDatas();
	
}
