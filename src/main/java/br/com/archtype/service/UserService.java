package br.com.archtype.service;

import java.util.List;
import java.util.Optional;

import br.com.archtype.model.entity.User;

public interface UserService {
	
	List<Optional<User>> getAll(Integer sorting, Integer skip, Integer limit);

	Optional<User> getUserId(Integer id);
	
	User createUser(User user);
	
	void deleteUser(Integer id);
}
