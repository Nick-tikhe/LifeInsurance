package com.example.demo.globalException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return errorMap;
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,String> handleUserNotFoundException(UserNotFoundException ex){
		Map<String,String> error=new HashMap();
		error.put("error", ex.getMessage());
		return error;
	}
	
}
