package com.email;

import java.util.HashSet;
import java.util.Set;

class BulkMain{
	public static void main(String[] args)  {
		BulkMail bmail=new BulkMail();
		Set<String> emails = get();
	
  for (String string:emails) {
	bmail.process(string);
}}
	private static Set<String> get(){
		
		Set<String> emails = new HashSet<>();
		emails.add("fazullurrahaman61@gmail.com");
		emails.add("rahaman@gmail.com");
		return emails;
		
	}
}


	
		
	
	