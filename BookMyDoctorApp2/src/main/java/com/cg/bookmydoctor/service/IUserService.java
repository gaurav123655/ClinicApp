package com.cg.bookmydoctor.service;

import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;

public interface IUserService {

	User addUser(User user) throws UserException, ValidateUserException;
	User updateUser(User user) throws UserException, ValidateUserException;
	User removeUser(User user) throws UserException;
	User getUser(User user)throws UserException;
	User getUserById(int userId) throws UserException;

	User authenticateUser(User user) throws UserException, ValidateUserException;


	boolean validateUser(User user) throws ValidateUserException;

}