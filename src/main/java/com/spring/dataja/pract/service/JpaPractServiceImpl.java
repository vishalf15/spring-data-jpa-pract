package com.spring.dataja.pract.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dataja.pract.dao.JpaDao;
import com.spring.dataja.pract.model.User;

@Service
public class JpaPractServiceImpl implements JpaPractService {

	@Autowired
	JpaDao jpaDao;

	@Override
	public List<User> addUser() {
		for(int i = 1; i <= 10; i++) {
			final User u = new User("Vishal_"+i, "Nimbalkar_"+i);
			this.jpaDao.save(u);
		}
		return this.jpaDao.findAll();
	}

	@Override
	public User getUserById(Long userId) {
		final Optional<User> user = this.jpaDao.findById(userId);
		return user.orElse(null);
	}

	@Override
	public List<User> findByFNameAndLName(String fName, String lName) {
		return this.jpaDao.findByFNameAndLName(fName, lName);
	}

}
