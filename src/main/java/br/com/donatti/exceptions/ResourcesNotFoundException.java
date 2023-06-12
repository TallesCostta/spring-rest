package br.com.donatti.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:25:11
 * 
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = -6353628152683779443L;

	public ResourcesNotFoundException(String ex) {
		super(ex);
	}
}
