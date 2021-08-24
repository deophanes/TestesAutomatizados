package com.devsuperior.bds02.service.exceptions;

public class ServiceNotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceNotfoundException(String msg) {
		super(msg);
	}
}
