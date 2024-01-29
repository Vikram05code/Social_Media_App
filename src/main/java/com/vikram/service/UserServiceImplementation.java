package com.vikram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikram.Repository.UserRepository;
import com.vikram.config.JwtProvider;
import com.vikram.exception.UserException;
import com.vikram.models.User;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User registerUser(User user) {
		User newUser = new User();
		//newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setGender(user.getGender());
		newUser.setPassword(user.getPassword());
		
		User savedUser = userRepository.save(newUser);
		return savedUser;
	}

	@Override
	public User findUserById(Integer userId) throws UserException {
Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("User do not exist with userId: "+userId);
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		
		return user;
	}

	@Override
	public User followUser(Integer reqUserId, Integer userId2) throws UserException {
		
		User reqUser = findUserById(reqUserId);
		User user2 = findUserById(userId2);
		
		user2.getFollowers().add(reqUser.getId());
		reqUser.getFollowings().add(userId2);
		
		userRepository.save(reqUser);
		userRepository.save(user2);
		
		
		return reqUser;
	}

	@Override
	public User updateUser(User user, Integer userId) throws UserException {

		Optional<User> user1 =	userRepository.findById(userId);
		
		if(user1.isEmpty()) {
			throw new UserException("User do not exist with userId: "+userId);
		}
		

			User oldUser = user1.get();
		
		
		if(user.getFirstName()!=null) {
			oldUser.setFirstName(user.getFirstName());
		}
		
		if(user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		if(user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		if(user.getPassword()!=null) {
			oldUser.setPassword(user.getPassword());
		}
		if(user.getGender()!=null) {
			oldUser.setGender(user.getGender());
		}
		
		User updatedUser = userRepository.save(oldUser);
		
			
			return updatedUser;
		
		
		
	}

	@Override
	public List<User> searchUser(String query) {
		
		return userRepository.searchUser(query);
	}

	@Override
	public User findUserByJwt(String jwt) {
		
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		//System.out.println("email: "+email);
		User user = userRepository.findByEmail(email);
		//System.out.println("user : "+user);
		return user;
	}

}
