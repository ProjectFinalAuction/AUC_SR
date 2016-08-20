package org.khmeracademy.auction.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/*@author Sor Thyreach 
HRD 4th generation
Build for Auction Project*/


@Configurable
public class AppConfig {
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		//Set gmail email id
		mailSender.setUsername("denhtlai@gmail.com");
		//Set gmail email password
		mailSender.setPassword("denhtlaiAuction");
		Properties prop = mailSender.getJavaMailProperties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.debug", "true");
		return mailSender;
	}
}
