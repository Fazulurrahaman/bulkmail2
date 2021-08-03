package com.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BulkMail {
	
	public void process(String string) throws Exception {
		   sendmail(string);
		   prepareMessage(null, string, string);
		   
		}
	
	
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
		
	}		

public static Message prepareMessage(Session session, String MyAccountEmail, String recepient) {
		
		Message message = new MimeMessage(session);
		
			try {
				message.setFrom(new InternetAddress(MyAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
				message.setSubject("vfgrt");
				
				String[] splittedArray = recepient.split("@");
				String name = splittedArray[0];
			//	System.out.println("Message sent to..:"+name);
				
				message.setText("Dear Mr." +name
						
						+ ",\n Greetings To You,\n" 
						+ "Welcome to my GitHub Account:http//github.com/Fazulurrahaman.\n" 
						+ "\nThanks & Regards,\n" 
						+ "Mr.Fazulur Rahaman, FullStack Developement Trainee,\n"  
						+ "Harris Infotech Pvt.Ltd,\n" 
						+ " E-mail:fazuluhit@gmail.com,\n" 
						+"Phone: +91-6385101136 ");
				
			} catch(Exception e) {
				e.printStackTrace();
				
			}	
			
		return message;
	}
	
	
	
}
