package com.springmvc.service;

import java.util.List;

import com.springmvc.model.User;
import com.springmvc.model.UserBean;

public interface UserService {
    
    User findById(long id);
     
     
   public void saveUser(UserBean user);
     
   public void updateUser(UserBean user);
     
   public void deleteUser(UserBean user);
   
    void deleteUserById(long id);
 
    List<UserBean> findAllUsers(); 
     
   
}