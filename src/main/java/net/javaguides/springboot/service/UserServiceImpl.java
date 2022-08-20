package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getAllUsers() {

		return repo.findAll();
	}

	@Override
	public User getUserById(Long userid) {

		return this.repo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userid));

	}

	@Override
	public User saveUser(User user) {

		User save = repo.save(user);

		return save;
	}

	@Override
	public void deleteUserById(Long userID) {
		User existingUser = repo.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("User not found Exception with id:" + userID));
		this.repo.delete(existingUser);

	}

	@Override
	public User updateUser(User user, Long userId) {
		User existingUser = repo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found with ID:" + userId));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		return this.repo.save(existingUser);

	}

}
