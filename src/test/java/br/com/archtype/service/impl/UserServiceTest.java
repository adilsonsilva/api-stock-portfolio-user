package br.com.archtype.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
	
	@Test
	void getUserUsers() {
		Optional<User> user = userService.getUserId(9);
		assertEquals(9, user.get().getDomain().getId());
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
			
			User userReturn = userService.createUser(user);
		}catch (Exception e) {
			fail();
		}
	}

	@Test
	void getDeleteUser() {
		try {
			userService.deleteUser(5);
		}catch (Exception e) {
			fail();
		}
	}
	
	
}
