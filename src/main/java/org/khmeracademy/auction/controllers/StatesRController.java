package org.khmeracademy.auction.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.States;
import org.khmeracademy.auction.services.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StatesRController {
	@Autowired
	private StatesService ss;
	
	@RequestMapping(value="/get-all-states",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getAllStates(){
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<States> arr = ss.getAllStates();
		try{
			if(!arr.isEmpty()){
				map.put("DATA", arr);
				map.put("MESSAGE", "Get all states successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot get all states!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/get-state/{id}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getState(
			@PathVariable int id
			){
		Map<String, Object> map = new HashMap<String, Object>();
		States s = ss.getState(id);
		try{
			if(s != null){
				map.put("DATA", s);
				map.put("MESSAGE", "Get all states successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot get all states!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-state",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> addState(@RequestBody States s){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(ss.insertState(s)){
				map.put("MESSAGE", "add state successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot add state!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-state",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateState(@RequestBody States s){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(ss.insertState(s)){
				map.put("MESSAGE", "update state successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot update state!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-state/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteState(
			@PathVariable int id
			){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(ss.deleteState(id)){
				map.put("MESSAGE", "delete state successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot delete state!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
