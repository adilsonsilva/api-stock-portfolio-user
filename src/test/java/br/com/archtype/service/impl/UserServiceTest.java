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
	void getInsertUser() {
		try {
			User user = User.builder()
					.cpf("09876523410")
					.email("unittest@teste.com.br")
					.fullName("Unit teste")
					.password("123456")
					.surName("teste")
					.build();
			
			userService.createUser(user);
		}catch (Exception e) {
			fail();
		}
	}

	@Test
	void getDeleteUser() {
		try {
			userService.deleteUser(1);
		}catch (Exception e) {
			fail();
		}
	}
	
	
}
