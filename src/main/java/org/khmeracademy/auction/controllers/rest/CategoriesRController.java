package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.Categories;
import org.khmeracademy.auction.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
public class CategoriesRController {
	
	@Autowired
	private CategoriesService cateService;
	
	
	//Get Categories Data as JSON to Web Service
	@RequestMapping(value="/get-categories",method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getCategories(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			ArrayList<Categories> cate = cateService.getCategories();
			if(!cate.isEmpty()){
				map.put("DATA", cate);
				map.put("STATUS", true);
				map.put("MESSAGE", "Data Found!");
			}else{
				map.put("STATUS", true);
				map.put("MESSAGE", "Data not Found!");
			}
		}catch(Exception e){
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	
	//Insert Categories to Database
	@RequestMapping(value="/add-categories", method= RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> addCategories(@RequestBody Categories cate){
		Map<String, Object> map = new HashMap<String,Object>();
		
		try{
			if(cateService.addCategories(cate)){
				map.put("STATUS", true);
				map.put("MESSAGE", "Insert Successed!");
			}else{
				map.put("STATUS", false);
				map.put("MESSAGE", "Insert Not Successed!");
			}
			
		}catch(Exception e){
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
	
	//Get Categories Data as JSON to Web Service
	@RequestMapping(value="/find-category-by-id/{categories_id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findCategoriesById(@PathVariable int categories_id){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			ArrayList<Categories> cate = cateService.findCategoriesById(categories_id);
			if(!cate.isEmpty()){
				map.put("DATA", cate);
				map.put("STATUS", true);
				map.put("MESSAGE", "Data Found!");
			}else{
				map.put("STATUS", true);
				map.put("MESSAGE", "Data not Found!");
			}
		}catch(Exception e){
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	
	
	//Update Categories 
	@RequestMapping(value="update-categories", method= RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateCategories(@RequestBody Categories cate){
		Map<String, Object> map = new HashMap<String,Object>();
		
		try{
			if(cateService.updateCategories(cate)){
				map.put("STATUS", true);
				map.put("MESSAGE", "Update Successed!");
			}else{
				map.put("STATUS", false);
				map.put("MESSAGE", "Update Not Successed!");
			}
			
		}catch(Exception e){
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
	//Delete Categories 
	@RequestMapping(value="/delete-categories/{category_id}", method= RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteCategories(@PathVariable int category_id){
		Map<String, Object> map = new HashMap<String,Object>();
		
		try{
			if(cateService.deleteCatedories(category_id)){
				map.put("STATUS", true);
				map.put("MESSAGE", "Delete Successed!");
			}else{
				map.put("STATUS", false);
				map.put("MESSAGE", "Delete Not Successed!");
			}
			
		}catch(Exception e){
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
