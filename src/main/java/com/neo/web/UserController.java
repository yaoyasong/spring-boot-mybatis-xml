package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.User;
import com.neo.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<User> getUsers() {
		List<User> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping("/getUser")
    public User getUser(Long id) {
    	User user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(User user, Role role) {
    	user.setRole(role);
    	user.setAddress(request.getAddress());
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(User user, Role role) {
    	user.setRole(role);
    	user.setAddress(request.getAddress());
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    @RequestMapping("/getUserByName")
    public ResponseEntity<User> getUserByName(@RequestParam("userName") String userName) {
    	User user = userMapper.getUserByName(userName);
    	if (user == null) {
    		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    
}