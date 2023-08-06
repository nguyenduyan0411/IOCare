//package com.fpoly.iocare.service.impl;
//
//import javax.mail.MessagingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.internet.MimeMessage;
//
//import com.fpoly.iocare.model.MailInfo;
//import com.fpoly.iocare.service.IEmailService;
//@Service
//public class EmailServiceImpl implements IEmailService {
//	
//	@Autowired
//	JavaMailSender sender;
//	
//	public void send(MailInfo mail) throws MessagingException{
//		MimeMessage message = sender.createMimeMessage();
//		MimeMessageHelper helper = 	new MimeMessageHelper(message, true, "utf-8");
//		helper.setFrom(mail.getFrom());
//		helper.setTo(mail.getTo());
//		helper.setSubject(mail.getSubject());
//		helper.setText(mail.getBody(), true);
//		
//		// Gửi message đến SMTP Server 
//		sender.send(message);
//	}
//	@Override
//	public void send(String to, String subject, String body) throws MessagingException{
//		this.send(new MailInfo(to, subject, body));
//	}
//}
