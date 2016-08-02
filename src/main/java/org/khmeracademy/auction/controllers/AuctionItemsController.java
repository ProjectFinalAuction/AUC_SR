package org.khmeracademy.auction.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.AuctionItems;
import org.khmeracademy.auction.services.AuctionItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuctionItemsController {
	
	@Autowired
	private AuctionItemsService aucItemsService;
	
	@RequestMapping(value="/get-auction-items", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllAuctionItems(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ArrayList<AuctionItems> auctionItems = aucItemsService.getAllAuctionItems();
			if(!auctionItems.isEmpty()){
				map.put("DATA", auctionItems);
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA FOUND!");
			}else{
				map.put("STATUS", true);
				map.put("MESSAGE", "DATA NOT FOUND!");
			}
		} catch (Exception e) {
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-auction-item", method = RequestMethod.POST)
	private ResponseEntity<Map<String, Object>> addAuctionItem(@RequestBody AuctionItems auctionItem){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(aucItemsService.addAuctionItem(auctionItem)){
				map.put("STATUS", true);
				map.put("MESSAGE", "Auction item has been inserted.");
			}else{
				map.put("STATUS", false);
				map.put("MESSAGE", "Auction item has not been inserted.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-auction-item", method = RequestMethod.PUT)
	private ResponseEntity<Map<String, Object>> updateAuctionItem(@RequestBody AuctionItems auctionItem){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(aucItemsService.updateActionItem(auctionItem)){
				map.put("STATUS", true);
				map.put("MESSAGE", "Auction item has been updated.");
			}else{
				map.put("STATUS", false);
				map.put("MESSAGE", "Auction item has not been updated.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-auction-item", method = RequestMethod.PUT)
	private ResponseEntity<Map<String, Object>> deleteAuctionItem(@RequestBody AuctionItems auctionItem){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(aucItemsService.deleteActionItem(auctionItem)){
				map.put("STATUS", true);
				map.put("MESSAGE", "Auction item has been deleted.");
			}else{
				map.put("STATUS", false);
				map.put("MESSAGE", "Auction item has not been deleted.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("STATUS", false);
			map.put("MESSAGE", "Error!");
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

}
