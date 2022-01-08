package br.com.archtype.service;

import java.util.List;

import br.com.archtype.model.entity.User;

public interface UserService {
	
	List<User> getAll(Integer sorting, Integer skip, Integer limit);

	User getUserId(Integer id);
	
	User createUser(User user);
}
