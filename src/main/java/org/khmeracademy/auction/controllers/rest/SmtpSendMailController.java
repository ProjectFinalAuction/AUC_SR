package org.khmeracademy.auction.controllers.rest;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.khmeracademy.auction.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SmtpSendMailController {
	@Autowired
	private SmtpMailSender smtpMailSender;	
	@RequestMapping("/send-mail/{to}")	
	public ResponseEntity<Map<String,Object>> sendMail(@PathVariable String to) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
		smtpMailSender.send(
				"chomrern@gmail.com", 
				"Denh Tlia <the cambodia auction website>", 
				"សូមអបអរសាទរ  "
				+ "អ្នកបាន​ ធ្វើការដេញថ្លៃដោយជោគជ័យ ហើយ\n"
				+ "សូមមកធ្វើការទទួលយក នូវអីវ៉ាន លេខ :' test123 ' នៅមជ្ឈមណ្ឌល HRD\n"
				+ "ព័ត៌មានបន្ថែមសូមទំនាក់ទំនងមកកាន់ : +855675255");
				// mail is sent
				map.put("MESSAGE", "Sending mail successfully");
				map.put("STATUS", true);
		} catch(MessagingException ex){
				map.put("MESSAGE", "Sending mail unsuccessfully");
				map.put("STATUS", false);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
