package com.example.bugtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bugtracker.entity.Login;
import com.example.bugtracker.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;
	
	@Autowired
	//private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "Login";
	}
	
	@GetMapping("/getuser")
	public ModelAndView getAllUsers() {
		List<Login>list=service.getAllUsers();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("LoginList","Login",list);
	}
	
	@GetMapping("/insertuser")
	public String bookRegister() {
		return "LoginRegister";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Login b) {
		service.save(b);
		return "redirect:/";
	}
	
	@RequestMapping("/updateuser/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Login b=service.getUserById(id);
		model.addAttribute("Login",b);
		return "LoginEdit";
	}
	
	@RequestMapping("/deleteuser/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/getuser";
	}
}
