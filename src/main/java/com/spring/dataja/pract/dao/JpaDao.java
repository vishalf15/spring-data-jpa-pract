package com.spring.dataja.pract.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dataja.pract.model.User;

public interface JpaDao extends JpaRepository<User, Long> {
	List<User> findByFNameAndLName(String fName, String lName);
}
