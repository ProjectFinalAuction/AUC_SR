package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.BidHistory;
import org.khmeracademy.auction.entities.BidHistoryInputUpdate;
import org.khmeracademy.auction.services.BidHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class BidHistoryRController {
	@Autowired
	private BidHistoryService bidHistoryService;
	
	/**
	 * Help method to get map object when select query
	 */
	public Map<String,Object> getMapObject(ArrayList<BidHistory> arr){
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
	
	
	@RequestMapping(value="/find-all-bid-history",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllBidHistory(){
		
		ArrayList<BidHistory> arr = bidHistoryService.findAllBidHistory();
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-bid-history-by-auction-id/{auction_id}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findBidHistoryByAuctionId(@PathVariable int auction_id){
		
		ArrayList<BidHistory> arr = bidHistoryService.findBidHistoryByAuctionId(auction_id);
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-bid-history-by-user-name/{user_name}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findBidHistoryByUserName(@PathVariable String user_name){
		
		ArrayList<BidHistory> arr = bidHistoryService.findBidHistoryByUserName(user_name);
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-bid-history-by-user-date/{bid_date}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findBidHistoryByDate(String bid_date){
		
		ArrayList<BidHistory> arr = bidHistoryService.findBidHistoryByDate(bid_date);
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/add-bid-history",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> addBidHistory(@RequestBody BidHistoryInputUpdate b){
		Map<String,Object> map = getMapObjectAfterTransaction(bidHistoryService.addBidHistory(b));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-bid-history",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateBidHistory(@RequestBody BidHistoryInputUpdate b){
		Map<String,Object> map = getMapObjectAfterTransaction(bidHistoryService.updateBidHistory(b));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-bid-history/{bid_id}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteBidHistory(@PathVariable int bid_id){
		Map<String,Object> map = getMapObjectAfterTransaction(bidHistoryService.deleteBidHistory(bid_id));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	//----- additional functions
	@RequestMapping(value="/find-bid-winner/{auction_id}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findBidWinner(@PathVariable int auction_id){
		
		BidHistory b = bidHistoryService.findBidWinner(auction_id);
		Map<String,Object> map = new HashMap<String, Object>(); 
		try{
			if(b!=null){
				map.put("DATA", b);
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
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}
