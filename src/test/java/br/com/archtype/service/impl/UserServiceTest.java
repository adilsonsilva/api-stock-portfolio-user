package br.com.archtype.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.archtype.model.entity.User;
import br.com.archtype.service.UserService;

@SpringBootTest
class UserServiceTest {
		
	@Autowired
	UserService userService;

	@Test
	void getUserLimitTeen() {
		List<Optional<User>> users = userService.getAll(0, 0, 10);
		Long qtdUser = users.stream().count();
		assertEquals(10, qtdUser);
	}

}
