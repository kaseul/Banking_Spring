package aca.mirim.controller;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aca.mirim.domain.UserVO;
import aca.mirim.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void getUserListTest() {
		System.out.println("Test getUserList,,,,,,,");
		
		List<UserVO> userList = userMapper.getUserList();
		
		for(UserVO user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void getUserTest() {
		System.out.println("Test getUser,,,,");
		
		System.out.println(userMapper.getUser("d"));
	}
	
	@Test
	public void insertUserTest() {
		System.out.println("Test insertUser,,,,");
		
		UserVO user = new UserVO();
		user.setId("a");
		user.setPassword("a");
		user.setUname("aaa");
		user.setBirth(new Date());
		user.setTel("010");
		
		userMapper.insertUser(user);
		
		getUserListTest();
	}
	
	@Test
	public void updateUserTest() {
		System.out.println("Test updateUser,,,");
		
		UserVO user = new UserVO();
		user.setId("a");
		user.setPassword("bb");
		user.setTel("01040675589");
		
		userMapper.updateUser(user);
		
		getUserListTest();
	}
	
	@Test
	public void deleteUserTest() {
		System.out.println("Test deleteUser,,,,,,");
		
		userMapper.deleteUser("a");
		
		getUserListTest();
	}
	
}

