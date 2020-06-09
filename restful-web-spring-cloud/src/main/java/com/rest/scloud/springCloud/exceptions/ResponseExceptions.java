package com.rest.scloud.springCloud.exceptions;

import java.util.Date;

public class ResponseExceptions  {
	private Date timestamp;
	private String message ;
	private String details ;
	private String uri;
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
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public ResponseExceptions(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public ResponseExceptions(Date timestamp, String message, String details,String uri) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.uri = uri;
	}
	
}
