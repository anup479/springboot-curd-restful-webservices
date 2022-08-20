package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.User;

@Service
public interface UserService {

	public List<User> getAllUsers();

	public User saveUser(User user);

	public void deleteUserById(Long userID);

	public User getUserById(Long userid);

	public User updateUser(User user, Long id);

}
