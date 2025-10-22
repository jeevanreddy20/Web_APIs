package com.WebApi.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebApi.Service.AuthService;
import com.WebApi.pojo.LoginUserDetails;
import com.WebApi.pojo.UserDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	AuthService service;
	
	
	@PostMapping("/signUp")
	 public ResponseEntity <Map<String, Object>> signUpUser(@Valid @RequestBody UserDetails user, BindingResult signupResult  ) {
		if(	signupResult.hasErrors()== true) {

			Map<String, Object> erros = new HashMap<String, Object>();
			
			signupResult.getFieldErrors().forEach(Err -> {
				erros.put(Err.getField(), Err.getDefaultMessage());
			});
			int [] num = {1,2,3,4};
			
			Map<String, Object> response = new LinkedHashMap<>();
			response.put("Result", "Failed");
			response.put("Message", "Invalid input");
			response.put("Hits", num);
			response.put("errors", erros);
			
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			String response = service.signupusers(user);
			
			Map<String, Object> res = new HashMap<String,Object>();
			
			
			Map<String, Object> userMap = new LinkedHashMap<String,Object>();
			userMap.put("name", user.getName());
			userMap.put("Email", user.getEmail());
			userMap.put("Age", user.getAge());
			res.put(response, "Sucessfull");
			res.put("User", userMap);
			return ResponseEntity.status(HttpStatus.OK).body(userMap);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/login")
	public Map<String, String> login(@Valid @RequestBody LoginUserDetails user,BindingResult result) {
		
		if(result.hasErrors() == true) {
			
			
			Map<String, String> errorMap = new HashMap<String,String>();
			Map<String, String> output = new HashMap<String,String>();
			output.put("Result", "Failed");
			result.getFieldErrors().forEach(error -> {
				errorMap.put(error.getField(), error.getDefaultMessage());
			});
			return errorMap;
		}else {
			String res = service.LoginUser(user);
			Map<String, String> response = new HashMap<String,String>();
			response.put(res, "success");
			return response;
		}
		
		
	}
}
