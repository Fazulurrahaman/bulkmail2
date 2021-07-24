package com.email;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	
	public static void main(String[] args) {
		 final String password = "9789807587";
		String fromEmail = "fazuluhit@gmail.com";
		String toEmail = "fazulurrahaman61@gmail.com";
		  
	 
			 	
			Properties properties = new Properties();
		properties.put("mail.smtp.auth"," true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp,port", "587");
		
		Session session = Session.getInstance(properties,new javax.mail.Authenticator(){
	          protected PasswordAuthentication getPasswordAuthentication() {
	        	return new PasswordAuthentication(fromEmail, password);
	        	
          }
	});
    MimeMessage msg = new MimeMessage(session);
    try {
    	msg.setFrom(new InternetAddress(fromEmail));
    	msg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
    	msg.setSubject("Welcome to the ONLINE FULL STACK JAVA,MEAN,MERN DEVELOPER COURSE.");
    	msg.setText("Dear,\n"
    	   		+ "Greetings To You,\n" 
    	   		+ "Welcome to my GitHub Account:http//github.com/Fazulurrahaman.\n "
    	   		+ "\n\nThanks & Regards,\n "
    	   		+ "Mr.Fazulur Rahaman, FullStack Developement Trainee,\n "
    	   		+ "Harris Infotech Pvt.Ltd,\n"
    	   		+ " E-mail:fazuluhit@gmail.com,\n   "
    	   		+"Phone: +91-6385101136 ");
    	
    	System.out.println("sent message");
    	Transport.send(msg,fromEmail,password);
	} catch (MessagingException e) {
		e.printStackTrace();}
  
	}



}
	


