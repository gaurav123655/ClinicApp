package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.serviceimpl.UserServiceImpl;

/**
 * @author Gaurav
 *         REST Controller with different HTTP methods
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "user"
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService ;

	//working
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) throws UserException, ValidateUserException {
		return userService.addUser(user);
	}

	//working
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) throws UserException, ValidateUserException {
		return userService.updateUser(user);
	}

	//working
	@DeleteMapping("/removeuser")
	public User removeUser(@RequestBody User user)  throws UserException{
		return userService.removeUser(user);
	}

//	//working
//	@GetMapping("/getuser/{userId}")
//	public User getUser(@PathVariable("userId") User user) throws UserException {
//		return userService.getUser(user);
//	}


	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws UserException, ValidateUserException {
		User loggedInUser = userService.authenticateUser(user);
		return ResponseEntity.ok(loggedInUser);
	}

	@GetMapping("/getuser/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") int userId) throws UserException {
		User user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}

}


