package com.example;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.example.model.SendMail;

public class MailingDemo {

	public static void main(String[] args) throws AddressException, MessagingException {
		SendMail sm = new SendMail();
		sm.sendEmail("b_b@abv.bg", "test", "Simple text");

	}

}
