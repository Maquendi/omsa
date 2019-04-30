package application.advisors;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private LocalDateTime timestamp;
	
	private String message;
	
	private String details;
	
	private String status;
	
	private String httpCodeMessage;
	
	public ExceptionResponse(LocalDateTime timestamp, String status, String message, String details,String httpCodeMessage) {
	    super();
	    this.timestamp = timestamp;
	    this.status = status;
	    this.message = message;
	    this.details = details;
	    this.httpCodeMessage = httpCodeMessage;
	  }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
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

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public void setHttpCodeMessage(String httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
