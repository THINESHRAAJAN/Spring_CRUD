package com.example.bugtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bugtracker.entity.Login;
import com.example.bugtracker.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository LRepo;
	
	public void save(Login b) {
		LRepo.save(b);
	}
	
	public List<Login> getAllUsers(){
		return LRepo.findAll();
	}
	
	public Login getUserById(int id) {
		return LRepo.findById(id).get();
	}
	public void deleteById(int id) {
		LRepo.deleteById(id);
	}

}
