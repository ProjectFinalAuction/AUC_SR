package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.AuctionInputUpdate;
import org.khmeracademy.auction.services.AuctionService;
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
public class AuctionRController {
	
	@Autowired
	private AuctionService auctionService;
	
	/**
	 * Help method to get map object when select query
	 */
	public Map<String,Object> getMapObject(ArrayList<Auction> arr){
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
	
	/**
	 * Help method to get map object when insert, update, delete 
	 */
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
	
	
	@RequestMapping(value="/find-all-auctions",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllAuctions() {
		
		ArrayList<Auction> arr = auctionService.findAllAuctions();
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-auction-by-id/{id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAuctionByID(@PathVariable int id) {
		
		ArrayList<Auction> arr = auctionService.getAuctionByID(id);
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}

	@RequestMapping(value="/find-auction-by-product-name/{product_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAuctionByProductName(@PathVariable String product_name) {
		
		ArrayList<Auction> arr = auctionService.findAuctionByProductName(product_name);
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}

	@RequestMapping(value="/find-auction-by-date/{trans_date}", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAuctionByDate(@PathVariable String trans_date) {
		
		ArrayList<Auction> arr = auctionService.findAuctionByDate(trans_date);
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}

	@RequestMapping(value="/add-auction", method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> addAuction(@RequestBody AuctionInputUpdate a) {
		Map<String,Object> map = getMapObjectAfterTransaction(auctionService.addAuction(a));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}

	
	@RequestMapping(value="/update-auction", method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateAuction(@RequestBody AuctionInputUpdate a) {
		Map<String,Object> map = getMapObjectAfterTransaction(auctionService.updateAuction(a));		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}

	@RequestMapping(value="/delete-auction/{auction_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteAuction(@PathVariable int auction_id) {
		Map<String,Object> map = getMapObjectAfterTransaction(auctionService.deleteAuction(auction_id));		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
