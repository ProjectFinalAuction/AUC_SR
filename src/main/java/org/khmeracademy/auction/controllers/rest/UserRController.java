package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.User;
import org.khmeracademy.auction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRController {
	@Autowired
	private UserService userService;
	//Request All Users
	@RequestMapping(value="/get-all-users", method= RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllUsers(){
		Map<String, Object> map= new HashMap<String, Object>();
		try {
			ArrayList<User> user = userService.getAllUsers();
			if(!user.isEmpty()){
				map.put("DATA", user);
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA FOUND!");
			}
			else{
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA NOT FOUND!");
			}
		} catch (Exception e) {
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	//Request User by Name
	@RequestMapping(value="/get-user-by-name/{user_name}", method= RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getUserByName(@PathVariable String user_name){
		Map<String, Object> map= new HashMap<String, Object>();
		User user = userService.getUserByName(user_name);
		try {
			if(user!=null){
				map.put("DATA", user);
				map.put("MESSAGE", "GET USER SUCCESSFULLY");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "GET USER FAIL!");
				map.put("STATE", true);
			}
		} catch (Exception e) {
				map.put("MESSAGE", "Error!");
				map.put("STATUS", false);
				e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	//Request User by Email
	@RequestMapping(value="/get-user-by-email/{email:.+}", method= RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getUserByEmail(@PathVariable String email){
		Map<String, Object> map= new HashMap<String, Object>();
		User user = userService.getUserByEmail(email);
		try {
			if(user!=null){
				map.put("DATA", user);
				map.put("MESSAGE", "GET USER SUCCESSFULLY");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "GET USER FAIL!");
				map.put("STATE", true);
			}
		} catch (Exception e) {
				map.put("MESSAGE", "Error!");
				map.put("STATUS", false);
				e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	//Request User By Any Field
	@RequestMapping(value="/get-user-by-any-field/{str_search:.+}", method= RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getUserByAnyField(@PathVariable String str_search){
		Map<String, Object> map= new HashMap<String, Object>();
		ArrayList<User> user = userService.getUserByAnyField(str_search);
		try {
			if(user!=null){
				map.put("DATA", user);
				map.put("MESSAGE", "GET USER SUCCESSFULLY");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "GET USER FAIL!");
				map.put("STATE", true);
			}
		} catch (Exception e) {
				map.put("MESSAGE", "Error!");
				map.put("STATUS", false);
				e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-user", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user){
		Map<String, Object> map= new HashMap<String, Object>();
		try {
			if(userService.addUser(user)){
				map.put("MESSAGE", "USER SUCCESSFULLY ADDED");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "ERROR!");
				map.put("STATUS", false);
			} 
		} catch (Exception e) {
				map.put("MESSAGE", "ERROR!");
				map.put("STATUS", false);
				e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-user", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody User user){
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			if(userService.updateUser(user)){
				map.put("MESSAGE", "SUCCESSFULLY UPDATED!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "UPDATE FAIL!!");
				map.put("STATUS", true);
			}
		} catch (Exception e) {
				map.put("MESSAGE", "ERROR!");
				map.put("STATUS", false);
				e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-user/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteUsers(@PathVariable int userId ){
		Map<String, Object> map= new HashMap<String, Object>();
		try {
			if(userService.deleteUsers(userId)){
				map.put("MESSAGE", "SUCCESSFULLY DELETED");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", true);
				map.put("STATUS", true);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}