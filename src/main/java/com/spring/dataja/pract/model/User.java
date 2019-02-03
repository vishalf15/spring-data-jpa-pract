package com.spring.dataja.pract.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table
public class User {

	@Id
	@GeneratedValue
	private Long userId;
	@Column private String fName;
	@Column private String lName;

	public User(String fn, String ln) {
		this.fName = fn;
		this.lName = ln;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.userId) + Objects.hash(this.fName) + Objects.hash(this.lName);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof User)) {
			return false;
		}
		final User u = (User) obj;
		return this.fName.equals(u.getFName()) && this.lName.equals(u.getLName());
	}
}
