package com.example.model;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class SendMail {
	
	private static final String OUR_SITES_PASSWORD = "zaq123edc";
	private static final String OUR_SITES_EMAIL_ADDRESS = "sitemybestnews@gmail.com";

	public void sendEmail(String recipient, String subject, String emailText) throws AddressException, MessagingException{
	
	GmailSender sender = new GmailSender();
	sender.setSender(OUR_SITES_EMAIL_ADDRESS, OUR_SITES_PASSWORD);
	sender.addRecipient(recipient);
	sender.setSubject(subject);
	String unsubscribemessage =  "\n\n\n\n"+"Click the link below to unsubscribe from our newsletter:";
	String unsubscribeLink = "\n\n"+"http://localhost:8080/MyProject/unsubscribe";
	
	sender.setBody(emailText+unsubscribemessage+unsubscribeLink);
//	sender.addAttachment("TestFile.txt");
	sender.send();
	
}
}
