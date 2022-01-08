package br.com.archtype.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6106802172924448138L;
	private Domain domain;
	private String fullName;
	private String surName;
	private String email;
	private String password;
	private String cpf;
	private Boolean active;
	private LocalDateTime registreDate;
}
