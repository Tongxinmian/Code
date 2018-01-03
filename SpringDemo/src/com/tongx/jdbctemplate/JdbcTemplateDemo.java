package com.tongx.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTemplateDemo {
	//添加
	@Test
	public void add() {
		//调用工具类方法得到jdbcTemplate对象
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		//调用方法实现操作
		String sql = "insert into user values(?,?)";
		int x = jdbcTemplate.update(sql, "Tongx", "520");
		System.out.println(x);
	}
	//修改
	@Test
	public void update() {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "update user set password=? where username=?";
		int x = jdbcTemplate.update(sql, "1314", "Tongx");
		System.out.println(x);
	}
	//删除
	@Test
	public void delete() {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "delete from user where username=?";
		int x = jdbcTemplate.update(sql, "Tongx");
		System.out.println(x);
	}
	//查询返回单个值
	@Test
	public void testCount() {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select count(*) from user";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	//查询返回对象
	@Test
	public void testObject() {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select * from user where username=?";
		//方法的第二个参数是Rowmapper接口，需要自己写类来实现，自己做数据封装
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "Tongx");
		System.out.println(user);
	}
	//查询返回list集合
	@Test
	public void testList() {
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		String sql = "select * from user";
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list);
	}
}

class MyRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		// 1. 从结果集中得到数据
		String username = rs.getString("username");
		String password = rs.getString("password");
		
		//2.将数据封装到对象中
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
	}
} 




