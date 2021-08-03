package com.email;

import java.util.HashSet;
import java.util.Set;

class BulkMain{
	public static void main(String[] args) throws Exception   {
		BulkMail bmail=new BulkMail();
		Set<String> emails = get();
	
 for (String string:emails) {
	
				bmail.process(string);
				
}
  }
	private static Set<String> get(){
		
		Set<String> emails = new HashSet<>();
		emails.add("fazulurrahaman61@gmail.com");
		emails.add("rahaman@gmail.com");
		return emails;
		
	}
}


	
		
	
	