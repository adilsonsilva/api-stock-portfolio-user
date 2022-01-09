package br.com.archtype.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.archtype.dao.UserDAO;
import br.com.archtype.model.entity.Domain;
import br.com.archtype.model.entity.User;
import br.com.archtype.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public List<Optional<User>> getAll(Integer sorting, Integer skip, Integer limit) {		
		return userDAO.getAll(sorting, skip, limit);
	}

	@Override
	public Optional<User> getUserId(Integer id) {
		return Optional.ofNullable(userDAO.getUserId(id).orElseThrow(() -> new RuntimeException("No data!")));
	}

	@Override
	public User createUser(User user) {
		User userBuilder = registreAndActiveUser(user);
		Integer id = userDAO.createUser(userBuilder);
		return preparetedReturn(userBuilder, id);
	}

	@Override
	public void deleteUser(Integer id) {
		getUserId(id);
		userDAO.deleteUser(id);
	}

	private User preparetedReturn(User userBuilder, Integer id) {

		User.UserBuilder userReturn = userBuilder.toBuilder();

		Domain domain = Domain.builder().id(id).build();
		userReturn.domain(domain).build();

		return userReturn.build();
	}

	private User registreAndActiveUser(User user) {
		User.UserBuilder userBuilder = user.toBuilder();
		userBuilder.active(Boolean.TRUE).registreDate(LocalDateTime.now()).build();
		return userBuilder.build();
	}

}
