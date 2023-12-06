package com.registro.login.Repository;

import java.util.Optional;

import com.registro.login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);

}
