package aca.mirim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aca.mirim.domain.LoginDTO;
import aca.mirim.domain.UserVO;
import aca.mirim.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserVO> getUserList() {
		return userMapper.getUserList();
	}

	@Override
	public UserVO getUser(String id) {
		return userMapper.getUser(id);
	}

	@Override
	public void register(UserVO user) {
		userMapper.insertUser(user);
	}

	@Override
	public void modify(UserVO user) {
		userMapper.updateUser(user);
	}

	@Override
	public void remove(String id) {
		userMapper.deleteUser(id);
	}
	
	@Override
	public UserVO login(LoginDTO login) {
		return userMapper.login(login);
	}
	
}
