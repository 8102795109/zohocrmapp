package com.zohocrmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.dto.Email;
import com.zohocrmapp.util.EmailService;


@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public String getEmailId(@RequestParam("email")String email, ModelMap model) {
		model.addAttribute("email", email);
		return "compose_email";
	}
	
	@RequestMapping("/triggerEmail")
	public String triggeremail(Email email, ModelMap model) {
	emailService.sendEmail(email.getEmail(), email.getSubject(), email.getContent());
    model.addAttribute("msg", "email sent successfully!!");
	return "compose_email";	
	}

}
