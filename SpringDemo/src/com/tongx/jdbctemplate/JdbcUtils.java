package com.tongx.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtils {
	public static JdbcTemplate getJdbcTemplate() {
		//配置数据库信息
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring");
		datasource.setUsername("root");
		datasource.setPassword("root");
		//返回jdbcTemplate对象
		return new JdbcTemplate(datasource);
	}
}
