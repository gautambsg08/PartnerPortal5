package com.testgaap.partnerportalnew.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.testgaap.partnerportalnew.app.model.OrderHistory;
import com.testgaap.partnerportalnew.app.model.Role;
import com.testgaap.partnerportalnew.app.model.User;
import com.testgaap.partnerportalnew.app.repository.UserRepository;
import com.testgaap.partnerportalnew.app.service.OrderHistoryService;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private OrderHistoryService ohService;
	
		
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/admin/add", consumes = {"application/x-www-form-urlencoded"})
	public String addUserByAdmin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("account_no") long account_no, @RequestParam("address") String address, @RequestParam("name") String name, @RequestParam("tele_no") long tele_no, User user)
	{
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAccount_no(account_no);
		user.setAddress(address);
		user.setName(name);
		user.setTele_no(tele_no);
		//role.setRole("USER");
		//user.setRoles(role);
		
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		userRepository.save(user);
		return "user added successfully...";
	}
	
	@GetMapping("/orderhistory")
	public List<OrderHistory> getOrderHistory()
	{
		return ohService.findOrderHistory();
	}
	
	@GetMapping("/registration")
	public ModelAndView getRegistrationPage()
	{
		ModelAndView mv =  new ModelAndView("registration.jsp");
		mv.addObject("role", Role.class);
		return mv;
	}
	
	

}
