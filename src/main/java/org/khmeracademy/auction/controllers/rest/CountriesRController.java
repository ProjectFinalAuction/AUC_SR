package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.Countries;
import org.khmeracademy.auction.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountriesRController {
	
	@Autowired
	private CountriesService cs;
	
	@RequestMapping(value="/get-all-countries",method=RequestMethod.GET)
	public ResponseEntity <Map<String,Object>> getAllCountries(){
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Countries> arr = cs.getAllCountries();
		try{
			if(!arr.isEmpty()){
				map.put("DATA", arr);
				map.put("MESSAGE", "Get all countries successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot get all countries!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/get-country-by-id/{id}", method=RequestMethod.GET)
	public ResponseEntity <Map<String, Object>> getCountryById(
			@PathVariable int id
			){
		Map<String, Object> map = new HashMap<String, Object>();
		Countries c = cs.getCountry(id);
		try{
			if(c!=null){
				map.put("DATA", c);
				map.put("MESSAGE", "Get country successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot get country!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-country", method=RequestMethod.POST)
	public ResponseEntity <Map<String, Object>> addCountry(@RequestBody Countries c){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(cs.insertCountry(c)){				
				map.put("MESSAGE", "Insert country successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot insert country!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-country", method=RequestMethod.PUT)
	public ResponseEntity <Map<String, Object>> updateCountry(@RequestBody Countries c){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(cs.updateCountry(c)){				
				map.put("MESSAGE", "update country successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot update country!");
				map.put("STATUS", true);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-country/{id}", method=RequestMethod.DELETE)
	public ResponseEntity <Map<String, Object>> deleteCountry(
			@PathVariable int id
			){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(cs.deleteCountry(id)){				
				map.put("MESSAGE", "delete country successfully!");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "Cannot delete country!");
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
