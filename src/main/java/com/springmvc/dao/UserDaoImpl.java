package com.springmvc.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.AbstractDao;
import com.springmvc.AbstractDaoImpl;
import com.springmvc.model.UserBean;

@Repository("userDao")
public class UserDaoImpl  extends AbstractDaoImpl  implements UserDao/*, AbstractDao<UserBean>*/{

	@Override
	public List<UserBean> findAllUsers() {
		sql="select u.user_id as id,u.username,u.address,u.email from user_detail u";
		 return jdbcTemplate.query(sql, new BeanPropertyRowMapper(UserBean.class) );
	}

	@Override
	public void save(UserBean obj) {
		
		jdbcTemplate.update(
		"insert into user_detail (user_id,username,address,email) values (supplier_seq.nextval,?,?,?)",
		obj.getUsername(),obj.getAddress(),obj.getEmail());
	}

	@Override
	public void update(UserBean obj) {

		sql = "update user_detail set username=?,address=?,email=? where user_id=?";
		jdbcTemplate.update(sql, obj.getUsername(), obj.getAddress(),
				obj.getEmail(),Long.valueOf(obj.getId()));

	}

	@Override
	public void delete(UserBean obj) {
	sql="delete from user_detail where user_id=? ";	
	jdbcTemplate.update(sql,Long.valueOf(obj.getId()));			
	}
	@Override
	public void deleteallUser(UserBean user) {
		sql="delete from user_detail  ";	
		jdbcTemplate.update(sql);			
				
	}

	

	
}
