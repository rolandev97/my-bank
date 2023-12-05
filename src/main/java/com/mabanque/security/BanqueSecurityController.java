package com.mabanque.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanqueSecurityController 
{
	@RequestMapping(value = "/mabanque/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(value = "/mabanque/")
	public String home()
	{
		return "redirect:/mabanque/operations";
	}
	
	@RequestMapping(value = "/mabanque/403")
	public String accessDenied()
	{
		return "403";
	}
}
