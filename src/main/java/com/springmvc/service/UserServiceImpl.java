package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 



 




import com.springmvc.dao.UserDao;
import com.springmvc.model.User;
import com.springmvc.model.UserBean;

@Service("userService")

public class UserServiceImpl implements UserService{
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	private static final AtomicLong counter = new AtomicLong();
    
    private static List<User> users;
     

	

	public void saveUser(UserBean user) {
		 userDao.save(user);
	    }
	public void updateUser(UserBean user) {
		 userDao.update(user);    }


	public List<UserBean> findAllUsers() {
		
		  return userDao.findAllUsers();    
	}

	public void deleteAllUsers() {
		 users.clear();
    }

	

	@Override
	public void deleteUser(UserBean user) {
		userDao.delete(user);
	}
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		
	}



}
