package br.com.archtype.model.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2952225280218551922L;
	private ContactType contactType;
	private  String data;
}
