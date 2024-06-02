package com.shivam.exceptions;

public class GroceryIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GroceryIdNotFoundException(String msg) {
		super(msg);
	}

}
