package com.jbk.Exception;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jbk.DTO.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String , String> invalidInput(MethodArgumentNotValidException ex){
		HashMap<String , String> error	= new HashMap<String , String>();
		List<FieldError> fieldErrors = ex.getFieldErrors();
		for(FieldError fieldError : fieldErrors) {
			error.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return error;
	}
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ExceptionResponse resourseNotFoundException(ResourseNotFoundException ex , HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setPath(request.getRequestURI());
		exceptionResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
		return exceptionResponse;
		
	}
}
