package com.spring.dataja.pract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dataja.pract.service.JpaPractService;

@RestController
public class DataJPAPractController {

	@Autowired
	JpaPractService jpaPractService;

	@GetMapping("/user/add")
	public ResponseEntity<?> addUsers() {
		return new ResponseEntity<>(this.jpaPractService.addUser(), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId) {
		return new ResponseEntity<>(this.jpaPractService.getUserById(userId), HttpStatus.OK);
	}


	@GetMapping("/user")
	public ResponseEntity<?> findByFNameAndLName(@RequestParam("fName") String fName, @RequestParam("lName") String lName) {
		return new ResponseEntity<>(this.jpaPractService.findByFNameAndLName(fName, lName), HttpStatus.OK);
	}
}
