package br.com.donatti.exceptions;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:28:15
 *
 */
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 102623879899335688L;

	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
