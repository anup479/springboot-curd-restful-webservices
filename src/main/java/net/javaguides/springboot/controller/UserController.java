package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// get all users
	@GetMapping
	public List<User> getAllUsers() {

		List<User> allUsers = userService.getAllUsers();

		return allUsers;
	}

	// get user by ID.
	@GetMapping("/{userID}")
	public User getUserById(@PathVariable Long userID) {
		User id = userService.getUserById(userID);
		return id;

	}

	// create all user
	@PostMapping
	public User createUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		return saveUser;

	}

	// update User!
	@PutMapping("/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable("userId") long userId) {

		return userService.updateUser(user, userId);
	}

	// delete User is not wokring

	@DeleteMapping("/userId")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") long userId) {
		userService.deleteUserById(userId);
		return ResponseEntity.ok().build();

	}

}
