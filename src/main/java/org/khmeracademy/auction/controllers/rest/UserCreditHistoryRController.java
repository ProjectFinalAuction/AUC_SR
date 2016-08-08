package org.khmeracademy.auction.controllers.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.auction.entities.UserCreditHistory;
import org.khmeracademy.auction.services.UserCreditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class UserCreditHistoryRController {
	@Autowired
	private UserCreditHistoryService userCreditHistoryService;
	
	/**
	 * Help method to get map object when select query
	 */
	public Map<String,Object> getMapObject(ArrayList<UserCreditHistory> arr){
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
	@RequestMapping(value="/find-all-user-credit-history", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllUserCreditHistory(){
		ArrayList<UserCreditHistory> arr = userCreditHistoryService.findAllUserCreditHistory();
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/find-user-credit-history-by-user-name/{user_name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findUserCreditHistoryByUserName(String user_name){
		ArrayList<UserCreditHistory> arr = userCreditHistoryService.findUserCreditHistoryByUserName(user_name);
		Map<String,Object> map = getMapObject(arr);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/add-user-credit-history", method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> addUserCreditHistory(UserCreditHistory uch){
		Map<String,Object> map = getMapObjectAfterTransaction(userCreditHistoryService.addUserCreditHistory(uch));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/update-user-credit-history", method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateUserCreditHistory(UserCreditHistory uch){
		Map<String,Object> map = getMapObjectAfterTransaction(userCreditHistoryService.updateUserCreditHistory(uch));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);	
	}
	@RequestMapping(value="/delete-user-credit-history/{credit_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteUserCreditHistory(@PathVariable int credit_id){
		Map<String,Object> map = getMapObjectAfterTransaction(userCreditHistoryService.deleteUserCreditHistory(credit_id));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}