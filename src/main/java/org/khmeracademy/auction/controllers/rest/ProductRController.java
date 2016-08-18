package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.auction.entities.Product;
import org.khmeracademy.auction.entities.ProductInputUpdate;
import org.khmeracademy.auction.services.ProductService;
import org.khmeracademy.auction.utils.HrdGeneratorUI;
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
public class ProductRController {
	@Autowired
	private ProductService ps;
	
	public Map<String,Object> getMapObject(ArrayList<Product> arr){
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

	@RequestMapping(value="/find-all-products",method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAllProducts() {
		ArrayList<Product> arr = ps.findAllProducts();
		Map<String, Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-product-by-name/{product_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findProductByName(@PathVariable String product_name){
		ArrayList<Product> arr = ps.findProductByName(product_name);
		Map<String, Object> map=getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-product-by-supplier/{supplier_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findProductBySupplier(@PathVariable String  supplier_name){
		ArrayList<Product> arr = ps.findProductBySupplier(supplier_name);
		Map<String, Object> map=getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-product-by-category/{category_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findProductByCategory(@PathVariable String category_name){
		ArrayList<Product> arr = ps.findProductByCategory(category_name);
		Map<String, Object> map=getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-products-has-supplier/{supplier_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findProductsHasSupplier(@PathVariable int supplier_id){
		ArrayList<Product> arr = ps.findProductsHasSupplier(supplier_id);
		Map<String, Object> map=getMapObject(arr);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-product", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addProduct(ProductInputUpdate p, HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println("API ZIN" + p);
			System.out.println("API => " + HrdGeneratorUI.decodeUnicodeFromObject(p));
			if(ps.addProduct(p, request) == 1){
				map.put("MESSAGE", "SUCCESS");
			}else{
				map.put("MESSAGE", "FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/update-product", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateProduct(@RequestBody ProductInputUpdate p ){
		Map<String, Object> map= getMapObjectAfterTransaction(ps.updateProduct(p));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-product/{product_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable int product_id  ){
		Map<String, Object> map= getMapObjectAfterTransaction(ps.deleteProduct(product_id));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
