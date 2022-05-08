package com.bhati.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
    
    
    @ExceptionHandler(value = SeatsNotAvailableException.class)
    public ResponseEntity<ErrorMessage> OpenWeatherException(SeatsNotAvailableException openweatherexception) {
    	
    	ErrorMessage message = new ErrorMessage(
    	        HttpStatus.CONFLICT.value(),
    	        new Date(),
    	        message1,
    	        message1);
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.CONFLICT);
    }
    /*
   @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessage> databaseConnectionFailsException(Exception exception) {
	   ErrorMessage message = new ErrorMessage(
   	        HttpStatus.CONFLICT.value(),
   	        new Date(),
   	        message2,
   	        message2);
       return new ResponseEntity<ErrorMessage>(message, HttpStatus.CONFLICT);
    }
    */
}
