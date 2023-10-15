package com.example.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bugtracker.entity.Login;


public interface LoginRepository extends JpaRepository<Login,Integer>  {

}
