package com.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;


public  abstract class AbstractDaoImpl  {

	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	
	public String sql =null;
	
	/*@Override
	public <E> void save(E obj){
		
	}
	
	@Override
	public <E> void update(E obj){
		
	}
	
	@Override
	public <E> void delete(E obj){
		
	}*/
}
