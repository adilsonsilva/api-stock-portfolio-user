package br.com.archtype.dao;

import java.util.List;

import br.com.archtype.model.entity.User;

public interface UserDAO {

	List<User> getAll(Integer sorting, Integer skip, Integer limit);

	User getUserId(Integer id);
	
	Integer createUser(User user);
}
