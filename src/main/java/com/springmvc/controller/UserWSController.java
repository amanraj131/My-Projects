package com.springmvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.springmvc.model.User;
import com.springmvc.model.UserBean;
import com.springmvc.service.UserService;

@Controller("userWSController")
@RequestMapping(value="/ws")
public class UserWSController {

	@Autowired
	@Qualifier("userService")
    private UserService userService;  //Service which will do all data retrieval/manipulation work
  
	private Gson gson =  new Gson();
     
    //-------------------Retrieve All Users--------------------------------------------------------
      
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public String listAllUsers(Map<String, Object> model) throws IOException {
        List<UserBean> users = userService.findAllUsers();
        model.put("data", gson.toJson(users));
        //response.getWriter().write(gson.toJson(users));
		return "data/ajaxdata";// ;
    }
  
  
     
    //-------------------Retrieve Single User--------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        return gson.toJson(user) ;
    }
  
      
      
   
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
  public String save(@RequestBody UserBean user){
	  userService.saveUser(user);
	  return "data/ajaxdata";
	  
  }
    
  //------------------- Update a User --------------------------------------------------------
      @RequestMapping(value="/user/upd",method = RequestMethod.POST)
    public String update(@RequestBody UserBean user){
    	userService.updateUser(user);
    	return "data/ajaxdata";
    }
    //------------------- Delete a User --------------------------------------------------------
      @RequestMapping(value="/user/del/{id}",method = RequestMethod.POST)
      public String delete(UserBean user){
      	userService.deleteUser(user);
      	return "data/ajaxdata";
      }
      
  
	
}
