package com.springmvc.dao;

import java.util.List;

import com.springmvc.AbstractDao;
import com.springmvc.model.User;
import com.springmvc.model.UserBean;

public interface UserDao extends AbstractDao<UserBean> {

	List<UserBean> findAllUsers(); 
	
	public void deleteallUser(UserBean user);
	   
}
