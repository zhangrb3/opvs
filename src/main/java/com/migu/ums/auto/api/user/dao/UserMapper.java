package com.migu.ums.auto.api.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.migu.ums.auto.api.user.domain.User;
import com.migu.ums.auto.commons.dao.BaseDao;

@Mapper
public interface UserMapper extends BaseDao<User, User, String>{
	@Select("select * from user where username = #{username}")
	public User findUserByName(@Param("username") String name);
	
	@Insert("insert into user(username,age)values(#{username},#{age})")
	public int insert(User user);
	
	@Insert("insert into user(username,age)values(#{username},#{age})")
	public int insertSelective(User user);
	
	@Delete("delete from user where id=#{id}")
	public int deleteByPrimaryKey(String id);
	
	@Select({"<script>",
    "SELECT * FROM user",
    "WHERE 1=1",
    "<when test='username!=null'>",
    "AND username = #{username}",
    "</when>",
    "<when test='age!=null'>",
    "AND age = #{age}",
    "</when>",
    "</script>"})
	public List<User> selectByExample(User user);
	
	@Update("update user set username = #{username} ,age = #{age} where id=#{id}")
	public int updateByPrimaryKeySelective(User user);
	
	@Select("select * from user where id=#{id}")
	User selectByPrimaryKey(String id);
	
	@Delete("delete from user where username = #{username} and age = #{age}")
	public int deleteByExample(User user);
	
}
 