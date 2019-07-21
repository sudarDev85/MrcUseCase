package com.abc.travel.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abc.travel.exception.InvalidInputException;

@ControllerAdvice
public class TravelExceptionHandler extends ResponseEntityExceptionHandler 
{
  
    @ExceptionHandler(InvalidInputException.class)
    public final ResponseEntity<Object> handleInvalidInputException(RuntimeException ex,
                                                WebRequest request) {
    	    
	        return handleExceptionInternal(ex, ex.getMessage(), 
	          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
       
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleUnknowException(
    	      RuntimeException ex, WebRequest request) {
    	        String bodyOfResponse = "UnKnow Server Error";
    	        return handleExceptionInternal(ex, bodyOfResponse, 
    	          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
   }
 
}