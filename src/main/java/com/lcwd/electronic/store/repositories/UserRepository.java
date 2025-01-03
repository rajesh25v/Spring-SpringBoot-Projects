package com.lcwd.electronic.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.electronic.store.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);

	List<User> findByNameContaining(String keywords);

}
