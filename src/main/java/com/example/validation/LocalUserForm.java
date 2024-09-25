package com.example.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//入力値の検証と保持
@Getter
@Setter
@UniqueEmail
public class LocalUserForm {
	private Integer id;
	
	@Size(min = 1, max = 100)
	@Email
	private String email;
		
	@ByteLength(min = 1, max = 100)
	private String name;
}
