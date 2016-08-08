package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.Category;
import org.khmeracademy.auction.services.CategoryService;
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
public class CategoryRController {

	@Autowired 
	private CategoryService cs;
//	* Help method to get map object when select query

	public Map<String,Object> getMapObject(ArrayList<Category> arr){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(!arr.isEmpty()){
				map.put("DATA", arr);
				map.put("MESSAGE", "SUCCESS");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "UNSUCCESS");
				map.put("STATUS", true);
			}				
		}catch(Exception e){
			map.put("MESSAGE", "ERROR");
			map.put("STATUS", false);
		}
		return map;
	}
	
//	 * Help method to get map object when insert, update, delete 

	public Map<String,Object> getMapObjectAfterTransaction(boolean b){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(b){
				map.put("MESSAGE", "SUCCESS");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "UNSUCCESS");
				map.put("STATUS", true);
			}				
		}catch(Exception e){
			map.put("MESSAGE", "ERROR");
			map.put("STATUS", false);
		}
		return map;
	}

	@RequestMapping(value="/find-all-categories",method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAllCategories() {
		ArrayList<Category> arr = cs.findAllCategories();
		Map<String, Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-category-by-name/{category_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findSupplierByName(@PathVariable String category_name){
		ArrayList<Category> arr=cs.findCategoryByName(category_name);
		Map<String, Object> map=getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-category-by-parent/{parent_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findSupplierByEmail(@PathVariable String parent_name){
		ArrayList<Category> arr=cs.findCategoryByParentCategory(parent_name);
		Map<String, Object> map=getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-category-by-any-field/{str_search}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findCategoryByAnyField(@PathVariable String str_search){
		ArrayList<Category> arr=cs.findCategoryByAnyField(str_search);
		Map<String, Object> map=getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-category", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addSupplier(@RequestBody Category c){
		Map<String, Object> map= getMapObjectAfterTransaction(cs.addCategory(c));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-category", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateSupplier(@RequestBody Category c){
		Map<String, Object> map= getMapObjectAfterTransaction(cs.updateCategory(c));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-category/{category_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable int category_id ){
		Map<String, Object> map= getMapObjectAfterTransaction(cs.deleteCategory(category_id));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
