package com.MyCourseApplication.validations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.MyCourseApplication.exceptions.ResourceNotFoundException;

/**
 * @author Tejasree
 * 
 */

@ControllerAdvice
public class ErrorHandlingAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ValidationError handleException(MethodArgumentNotValidException exception) {
		return createValidationError(exception);
	}

	private ValidationError createValidationError(MethodArgumentNotValidException e) {
		return ValidationErrorBuilder.fromBindingErrors(e.getBindingResult());
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody ResponseEntity<Error> handleUserNotFoundException(ResourceNotFoundException ue) {
		return new ResponseEntity<Error>(new Error(ue.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<Error> handleException(Exception e) {
		return new ResponseEntity<Error>(new Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
