package br.com.archtype.dao;

import java.util.List;
import java.util.Optional;

import br.com.archtype.model.entity.User;

public interface UserDAO {

	List<Optional<User>> getAll(Integer sorting, Integer skip, Integer limit);

	Optional<User> getUserId(Integer id);
	
	Integer createUser(User user);

	void deleteUser(Integer id);
	
	Optional<User> getUserForEmail(String email);
}
