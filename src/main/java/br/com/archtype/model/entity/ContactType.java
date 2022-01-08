package br.com.archtype.model.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4121036870902497825L;
	private String type;
	private String description;

}
