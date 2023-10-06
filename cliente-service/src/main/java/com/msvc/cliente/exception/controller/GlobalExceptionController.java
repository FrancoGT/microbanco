package com.msvc.cliente.exception.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.msvc.cliente.exception.ResourceNotFoundException;
import com.msvc.cliente.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionController 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotException(ResourceNotFoundException resourceNotFoundException)
	{
		String mensaje = resourceNotFoundException.getMessage();
		ApiResponse response = new ApiResponse().builder()
				.message(mensaje)
				.success(true)
				.status(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}