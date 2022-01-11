package br.com.archtype.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.archtype.exception.InsertUserException;
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
	
	@Test
	void getUserLimitTeenNotFound() {
		assertThrows(EmptyResultDataAccessException.class, () -> userService.getAll(0, 100, 100));
	}
	
	@Test
	void getUserUsers() {
		Optional<User> user = userService.getUserId(9);
		assertEquals(9, user.get().getDomain().getId());
	}
	
	@Test
	void userNotFound() {
		assertThrows(EmptyResultDataAccessException.class, () -> userService.getUserId(100));
	}
	
	@Test
	void getInsertUser() {
		try {
			User user = User.builder()
					.cpf("13376523415")
					.email("unittest6@teste.com.br")
					.fullName("Unit teste")
					.password("123456")
					.surName("teste2")
					.build();
			
			userService.createUser(user);
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	void getInsertUserEmailUniqueExisting() {
		
			User user = User.builder()
					.cpf("13376523415")
					.email("siclano@gmail.com")
					.fullName("Unit teste")
					.password("123456")
					.surName("teste2")
					.build();
			
			assertThrows(DuplicateKeyException.class, () -> userService.createUser(user));
	}

	@Test
	void getDeleteUser() {
		try {
			userService.deleteUser(5);
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	void getDeleteUserNotExisting() {
		assertThrows(EmptyResultDataAccessException.class, () -> userService.deleteUser(100));
	}
	
	
}
