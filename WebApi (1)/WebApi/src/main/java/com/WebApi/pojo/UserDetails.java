package com.WebApi.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDetails {
	@NotBlank(message = "Name is mandatory")
	@NotNull(message = "Name should not be null")
	private String name;
	@NotNull(message = "Please Enter the Age")
	@NotBlank(message = "Please Enter the Age")
	@Size(min = 2,message = "age should be above 18")
	private String age;
	@NotBlank(message = "Enter the Email..!!")
	@NotNull(message = "Enter the Email")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	@NotBlank(message = "Enter your PhoneNumber bslnk")
	@NotNull(message = "Enter your PhoneNumber null")
	@Size(min = 10,message = "check you mobile number")
	private String phoneNumber;
	@NotBlank(message = "Enter your Password")
	@NotNull(message = "Enter your password")
	@Size(min=8,max = 10,message = " password should be greater than 8 words")
	private String password;
	
}
