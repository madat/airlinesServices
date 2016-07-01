package com.ws.airlines.resource.exception;

public class DatanotFoundException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = -8060267955178627979L;

	public DatanotFoundException(String errorMsg){
		super(errorMsg);
	}

}
