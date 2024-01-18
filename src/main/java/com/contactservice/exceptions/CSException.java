package com.contactservice.exceptions;

import com.contactservice.enums.ErrorCodes;

import lombok.Getter;
import lombok.Setter;

/**
 * Processes an {@link NSException } request.
 * 
 * @author Raghu
 *
 */

@Getter
@Setter
public class CSException extends RuntimeException {

	/**
	 * NS(Next Science)Exception.
	 *
	 */

	private static final long serialVersionUID = 1L;

	private Integer errorCode;

	private String message;

	public CSException(ErrorCodes errorCode, String message) {
		super(message);
		this.errorCode = errorCode.getCode();
		this.message = message;
	}

	public CSException(ErrorCodes errorCode, Exception ex) {
		super(ex);
		this.errorCode = errorCode.getCode();
		this.message = ex.getMessage();
	}

}
