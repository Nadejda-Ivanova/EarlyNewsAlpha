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
	sender.setBody(emailText);
//	sender.addAttachment("TestFile.txt");
	sender.send();
	
}
}
