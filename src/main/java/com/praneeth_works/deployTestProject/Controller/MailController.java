package com.praneeth_works.deployTestProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
@RequestMapping("mail")
public class MailController {
	
	@Autowired
	JavaMailSender mailSender;
	
	@GetMapping("/sendMail")
	public String sendMail(@RequestParam("email") String email) {
		try
		{
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("praneethscienceprojectscodes@gmail.com");
			mailMessage.setTo(email);
			mailMessage.setSubject("sent using java");
			mailMessage.setText("This is the first email using java");
			
			mailSender.send(mailMessage);
			return "Email sent successfully";
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
