package com.flipkart.framework.objects.exceptions;

import com.flipkart.framework.logger.ScriptLogger;

public class HTMLElementNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HTMLElementNotFoundException(Exception e, String message){
		super(message);
		ScriptLogger.error(e);
	}

}
