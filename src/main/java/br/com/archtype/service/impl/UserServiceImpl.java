package br.com.archtype.service.impl;

import java.time.LocalDateTime;
import java.util.List;

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
	public List<User> getAll(Integer sorting, Integer skip, Integer limit) {
		return userDAO.getAll(sorting, skip, limit);
	}

	@Override
	public User getUserId(Integer id) {
		return userDAO.getUserId(id);
	}

	@Override
	public User createUser(User user) {
		User userBuilder = registreAndActiveUser(user);
		Integer id = userDAO.createUser(userBuilder);
		return preparetedReturn(userBuilder, id);
	}

	private User preparetedReturn(User userBuilder, Integer id) {

		User.UserBuilder userReturn = userBuilder.toBuilder();

		Domain domain = Domain.builder()
								.id(id)
							.build();
		userReturn.domain(domain)
		   .build();

		return userReturn.build();
	}

	private User registreAndActiveUser(User user) {
		User.UserBuilder userBuilder = user.toBuilder();
		userBuilder.active(Boolean.TRUE)
				   .registreDate(LocalDateTime.now())
			.build();
		return userBuilder.build();
	}

}
