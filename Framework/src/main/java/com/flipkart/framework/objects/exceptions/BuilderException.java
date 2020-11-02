package com.flipkart.framework.objects.exceptions;

public class BuilderException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9208275300373257167L;

	public BuilderException(final String message) { super(message); }
	
	public BuilderException(final Throwable t) { super(t); }
	
	public BuilderException(final String message, final Throwable t) { super(message, t); }
	

}
