package org.example.securiry.repositries;

import org.example.securiry.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositry extends JpaRepository<User,Integer> {
  public  Optional<User> findByEmail(String email);

 public  boolean existsByEmail(String email);
}
