package com.vikram.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vikram.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByEmail(String email);
	
	@Query("select u from User u WHERE u.firstName LIKE %:query% OR u.lastName LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);
	
}
