package com.mabanque.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) 
	{	
		BCryptPasswordEncoder b = new BCryptPasswordEncoder(6);
		System.out.println(b.encode("user"));
	}
}
