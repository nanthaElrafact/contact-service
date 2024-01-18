package com.contactservice.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Processes an {@link NextScienceServiceExceptionalHandler } request.
 * 
 * @author Raghu
 *
 */

@ControllerAdvice
@RestController
public class ContactServiceExceptionalHandler {

	/**
	 * Returns custom error response on occurrence of custom exception.
	 * 
	 * @param e
	 * @param response
	 * @return
	 */

	@ExceptionHandler(value = CSException.class)
	public ErrorResponse handleContentNotFoundException(CSException e, HttpServletResponse response) {
		response.setStatus(e.getErrorCode());
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getMessage());
		error.setErrorCode(e.getErrorCode());
		error.setSuccess(false);
		return error;
	}
}
