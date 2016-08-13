package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.Supplier;
import org.khmeracademy.auction.services.SupplierService;
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
public class SupplierRController {
	@Autowired 
	private SupplierService ss;
//	* Help method to get map object when select query

	public Map<String,Object> getMapObject(ArrayList<Supplier> arr){
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

	@RequestMapping(value="/find-all-suppliers",method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAllSuppliers() {
		ArrayList<Supplier> arr = ss.findAllSuppliers();
		Map<String, Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-supplier-by-name/{supplier_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findSupplierByName(@PathVariable String supplier_name){
		ArrayList<Supplier> s=ss. findSupplierByName(supplier_name);
		Map<String, Object> map=getMapObject(s);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-supplier-by-email/{email:.+}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findSupplierByEmail(@PathVariable String email){
		ArrayList<Supplier> s=ss.findSupplierByEmail(email);
		Map<String, Object> map=getMapObject(s);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-supplier-by-any-field/{str_search:.+}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findSupplierByAnyField(@PathVariable String str_search){
		ArrayList<Supplier> s=ss.findSupplierByAnyField(str_search);
		Map<String, Object> map=getMapObject(s);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-supplier-by-id/{supplier_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findSupplierById(@PathVariable int supplier_id){
		ArrayList<Supplier> s=ss.findSupplierById(supplier_id);
		Map<String, Object> map=getMapObject(s);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/add-supplier", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addSupplier(@RequestBody Supplier s){
		Map<String, Object> map= getMapObjectAfterTransaction(ss.addSupplier(s));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-supplier", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateSupplier(@RequestBody Supplier s ){
		Map<String, Object> map= getMapObjectAfterTransaction(ss.updateSupplier(s));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-supplier/{supplier_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteSupplier(@PathVariable int supplier_id ){
		Map<String, Object> map= getMapObjectAfterTransaction(ss.deleteSupplier(supplier_id));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}



	
}
