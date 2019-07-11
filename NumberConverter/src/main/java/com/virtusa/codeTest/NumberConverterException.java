package com.virtusa.codeTest;

public class NumberConverterException extends Exception{

	private static final long serialVersionUID = 1L;

	public NumberConverterException(String msg){
//		super(msg);
		
		System.out.println("Exception::"+msg);
	}
}
