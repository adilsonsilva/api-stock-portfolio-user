package br.com.archtype.model.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Domain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3208253233559225940L;

	private Integer id;

}
