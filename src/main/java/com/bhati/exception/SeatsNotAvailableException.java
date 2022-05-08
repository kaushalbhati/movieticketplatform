package com.bhati.exception;

public class SeatsNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	  public SeatsNotAvailableException(String msg) {
	    super(msg);
	  }
	
}
