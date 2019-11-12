package com.miniproject.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.springbatch.model.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {
}
