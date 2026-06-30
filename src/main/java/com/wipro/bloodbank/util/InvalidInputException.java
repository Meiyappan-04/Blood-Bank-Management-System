package com.wipro.bloodbank.util;

import java.sql.SQLException;

public class InvalidInputException extends SQLException{
	public InvalidInputException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "Invlaid Input Error: "+ getMessage();
	}
}
