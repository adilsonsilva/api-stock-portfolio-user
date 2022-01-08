package br.com.archtype.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class APIError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1341173577203813979L;
	private LocalDateTime timestamp;
	private Integer statusCode;
	private String error;
	private String message;
	private String path; 
}
