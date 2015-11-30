package com.ywq.ssm.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {

	/***mail Info Start***/
	private String from = "yangwq@ucap.com.cn";
	private String to  = "1573147561@qq.com";
	private String[] toMany = new String[]{"1573147561@qq.com","ywqjob@163.com"};
	private String subject = "放假通知";
	private String plain_text = "各位好：放假3天!";
	/***mail Info End***/

	@Resource(name="mailSender")
	private JavaMailSender mailSender;
	
	@RequestMapping("/send/text")
	public void sendTextMail(){
		try {
			//1. send plain text message
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			//message.setTo(to);send to one person
			message.setTo(toMany);//send to many person
			message.setSubject(subject);
			message.setText(plain_text);
			
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String html_text = "<b>各位好</b>：" +"<br/>" +"&nbsp;&nbsp;<h1>后天放假3天!</h1>" +"<br/>" +"<b>人事部</b>";
	private String cc = "763874651@qq.com";
	private String UTF_8 = "UTF-8";
	@RequestMapping("/send/html")
	public void sendHtmlMail(){
		try {
			/*****Sending Attachments and Inline Resources*****/
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			//use the true flag to indicate you need a mutipart message
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,UTF_8);
			//use the true flag to indicate the text included is html
			helper.setText(html_text,true);
			helper.setSubject(subject);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			
			//add attachments
			FileSystemResource img = new FileSystemResource("C:/Users/Public/Pictures/Sample Pictures/yujinxiang.jpg");
			helper.addAttachment(MimeUtility.encodeText("苏琪3级片剧照.jpg"), img);
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}