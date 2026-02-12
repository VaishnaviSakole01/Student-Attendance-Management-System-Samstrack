package com.tka.sams.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.sams.api.dao.UserDao;
import com.tka.sams.api.entity.Users;
import com.tka.sams.api.model.LoginRequest;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public Users loginUser(LoginRequest request) {
		return dao.loginUser(request);
	}

	public Users registerUser(Users user) {
		return dao.registerUser(user);
	}

	public Users getUserByName(String username) {
		return dao.getUserByName(username);
	}

	public List<Users> getAllUser() {
		return dao.getAllUser();
	}

	public Users updateUser(Users user) {
		return dao.updateUser(user);
	}

	public String deleteUserById(String username) {
		return dao.deleteUserById(username);
	}

	public List<Users> getAllAdmins() {
		return dao.getAllAdmins();
	}
	
	public List<Users> getAllFaculties() {
		return dao.getAllFaculties();
	}

}
