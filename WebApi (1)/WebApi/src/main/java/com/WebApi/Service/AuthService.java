package com.WebApi.Service;

import org.springframework.stereotype.Service;

import com.WebApi.pojo.LoginUserDetails;
import com.WebApi.pojo.UserDetails;

@Service
public class AuthService {


	public String signupusers(UserDetails user) {
//		if(!user.getEmail().contains(".com")) {
//			return "invalid email";
//		}
		String age = user.getAge();
		int a = Integer.parseInt(age);
		
		 if(a<17) {
			return "Invalid Age : age should greaterthan 18 or equal to 18";
		}else if(user.getPassword().length()==0 || user.getPassword().length()<=5){
			return "invalid password";
		}
		else {
			return "sign up succesfull";
		}	
	}
	public String LoginUser(LoginUserDetails user) {
//		String email ="jeevankumarreddy14@gmail.com"; 
//		String password = "Jeevan@14";
//		if(user.getEmail().equals(email) && user.getPassword().equals(password) ) {
//			return "Login succesfull";
//		} else {
//			return "Invalid credentials";
//		}
		return user.toString();
	}
}
