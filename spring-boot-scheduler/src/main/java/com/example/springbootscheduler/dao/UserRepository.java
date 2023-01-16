package com.example.springbootscheduler.dao;

import com.example.springbootscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
