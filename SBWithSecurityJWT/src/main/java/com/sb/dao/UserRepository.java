package com.sb.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
Optional<User> findByUserName(String userName);
}
