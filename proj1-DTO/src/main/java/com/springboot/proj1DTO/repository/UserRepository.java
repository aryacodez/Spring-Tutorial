package com.springboot.proj1DTO.repository;

import com.springboot.proj1DTO.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
