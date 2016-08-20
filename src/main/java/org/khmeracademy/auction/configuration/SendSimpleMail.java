package org.khmeracademy.auction.configuration;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/*@author Sor Thyreach 
 HRD 4th generation
 Build for Auction Project*/

public class SendSimpleMail {
	public static void main(String[] args) throws MessagingException {
		   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	       ctx.register(AppConfig.class);
	       ctx.refresh();
	       JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
		   MimeMessage mimeMessage = mailSender.createMimeMessage();
      	   MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
      	   mailMsg.setFrom("denhtlai@gmail.com");
      	   mailMsg.setTo("chomrern@gmail.com");
      	   mailMsg.setSubject("Denh Tlia <the cambodia auction website>");
      	   mailMsg.setText("សូមអបអរសាទរ  "
      	   		+ "អក្នបាន​ ធ្វើការដេញថ្លៃដោយជោគជ័យ ហើយ\n"
      	   		+ "សូមមកធ្វើការទទួលយក នូវអីវ៉ាន លេខ :' test123 ' នៅមជ្ឈមណ្ឌល  HRD\n"
      	   		+ "ពត័មាន បន្ថែមសូមទំនាក់ ទំនង មកកាន់ : 023 xxx xxx");
      	   		
	       mailSender.send(mimeMessage);
	       System.out.println("---Email has been send !!!!! Done---");
	}
}
