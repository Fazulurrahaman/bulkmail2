package com.email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BulkMail {
	
	
	public static void sendmail( String recipient) throws Exception {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		
		String MyAccountEmail = "fazuluhit@gmail.com";
		String password = "9789807587";
		
		Session session = Session.getInstance(properties,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MyAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session,MyAccountEmail,recipient);
		
		Transport.send(message);
		System.out.println("Message sent");
		
	}

	private static Message prepareMessage(Session session,String MyAccountEmail,String recepient) {
		
		Message message = new MimeMessage(session);
		
			try {
				message.setFrom(new InternetAddress(MyAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
				message.setSubject("vfgrt");
				
				
				
				message.setText("Dear Mr." 
						
						+ ",\n Greetings To You,\n" 
						+ "Welcome to my GitHub Account:http//github.com/Fazulurrahaman.\n" 
						+ "\nThanks & Regards,\n" 
						+ "Mr.Fazulur Rahaman, FullStack Developement Trainee,\n"  
						+ "Harris Infotech Pvt.Ltd,\n" 
						+ " E-mail:fazuluhit@gmail.com,\n" 
						+"Phone: +91-6385101136 ");
			} catch(Exception ex) {
				Logger.getLogger(BulkMail.class.getName()).log(Level.SEVERE,null,ex);
				
			}	
		return message;
	}
	
	
}
