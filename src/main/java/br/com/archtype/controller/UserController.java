package br.com.archtype.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.archtype.model.entity.User;
import br.com.archtype.service.UserService;

@RestController
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<Optional<User>>> getUsers(@RequestParam(defaultValue = "1", value = "sorting") Integer sorting,
			@RequestParam(defaultValue = "20", value = "skip") Integer skip,
			@RequestParam(defaultValue = "10", value = "limit") Integer limit) {
		return new ResponseEntity<>(userService.getAll(sorting, skip, limit), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserId(@PathVariable Integer id) {
		return new ResponseEntity<>(userService.getUserId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
	             

}
