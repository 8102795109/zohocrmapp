package com.zohocrmapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String to, String subject, String email) {
		SimpleMailMessage m= new SimpleMailMessage();
		m.setTo(to);
		m.setSubject(subject);
		m.setText(email);
		javaMailSender.send(m);
	}

}
