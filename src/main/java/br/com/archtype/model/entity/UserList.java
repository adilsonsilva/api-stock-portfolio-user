package br.com.archtype.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserList extends ArrayList<User> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4018953348790230157L;


}
