package br.com.donatti.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:25:11
 * 
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = -6353628152683779443L;

	public UnsupportedMathOperationException(String ex) {
		super(ex);
	}
}
