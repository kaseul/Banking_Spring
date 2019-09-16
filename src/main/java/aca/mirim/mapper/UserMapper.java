package aca.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import aca.mirim.domain.DataVO;
import aca.mirim.domain.LoginDTO;
import aca.mirim.domain.UserVO;

public interface UserMapper {
	
	@Select("SELECT * FROM userTbl")
	public List<UserVO> getUserList();
	
	@Select("SELECT * FROM userTbl WHERE id=#{id}")
	public UserVO getUser(String id);
	
	@Select("SELECT * FROM userTbl WHERE id=#{loginId} AND password=#{loginPw}")
	public UserVO login(LoginDTO login);
	
	@Insert("INSERT INTO userTbl VALUES(#{id}, #{password}, #{uname}, #{birth}, #{tel})")
	public void insertUser(UserVO user);
	
	@Update("UPDATE userTbl SET password=#{password}, tel=#{tel} WHERE id=#{id}")
	public void updateUser(UserVO user);
	
	@Delete("DELETE userTbl WHERE id=#{id}")
	public void deleteUser(String id);
	
	@Select("SELECT column_name, data_type, data_length FROM cols WHERE table_name = 'USERTBL'")
	public List<DataVO> getDatas();
	
}
