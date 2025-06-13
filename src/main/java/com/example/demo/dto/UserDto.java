package com.example.demo.dto;

import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.User;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

	private Long id;
	@NotNull
	@NotBlank(message="Name is required")
	private String firstName;
	@NotNull
	@NotBlank(message="Name is required")
	private String lastName;
	@NotNull
	
	private Long moNum;
	@NotNull
	@Min(value=18,message="age should be above 18")
	@Max(value=60,message="age should be belove 60")
	private Integer age;
}
