package com.spring.dataja.pract.service;

import java.util.List;

import com.spring.dataja.pract.model.User;

public interface JpaPractService {
	List<User> addUser();

	User getUserById(Long userId);

	List<User> findByFNameAndLName(String fName, String lName);
}
