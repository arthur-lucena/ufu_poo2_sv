package edu.ufu.poo2.si.util.exceptions;

public class ErroException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ErroException(String msg, Exception e) {
		super(msg, e);
	}
}
