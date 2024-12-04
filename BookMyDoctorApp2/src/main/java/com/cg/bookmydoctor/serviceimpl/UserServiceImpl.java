package com.cg.bookmydoctor.serviceimpl;

import java.util.Optional;

import com.cg.bookmydoctor.exception.ValidateAdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dao.IUserDao;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.service.IUserService;
import com.cg.bookmydoctor.util.AllConstants;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User addUser(User user) throws UserException, ValidateUserException {
		validateUser(user);
		Optional<User> userDb = userDao.findById(user.getUserId());
		if (userDb.isPresent()) {
			throw new UserException("User already exists with ID : " + user.getUserId());
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User updateUser(User user) throws UserException, ValidateUserException {
		validateUser(user);
		Optional<User> userDb = userDao.findById(user.getUserId());
		if (!userDb.isPresent()) {
			throw new UserException("User doesn't exist with ID : " + user.getUserId());
		} else {
			return userDao.save(user);
		}
	}

	@Override
	public User getUserById(int userId) throws UserException {
		Optional<User> userDb = userDao.findById(userId);
		if (userDb.isPresent()) {
			return userDb.get();
		} else {
			throw new UserException("User doesn't exist with ID: " + userId);
		}
	}

	@Override
	public User removeUser(User user) throws UserException {
		Optional<User> userDb = userDao.findById(user.getUserId());
		if (!userDb.isPresent()) {
			throw new UserException("User with ID : " + user.getUserId() + " doesn't exist to delete");
		} else {
			userDao.deleteById(user.getUserId());
		}
		return user;
	}

	@Override
	public User getUser(User user) throws UserException {
		Optional<User> userDb = userDao.findById(user.getUserId());
		if (userDb.isPresent()) {
			return userDb.get();
		} else {
			throw new UserException("User doesn't exist with ID : " + user.getUserId());
		}
	}

	@Override
	public User authenticateUser(User user) throws UserException, ValidateUserException {
		System.out.println("Login email id: " + user.getEmailId());
		validateUser(user);
		Optional<User> userDb = userDao.findByEmailId(user.getEmailId()); // Assuming findByEmail is defined in IUserDao
		if (userDb.isPresent()) {
			User foundUser = userDb.get();
			if (foundUser.getPassword().equals(user.getPassword())) {
				return foundUser;
			} else {
				throw new UserException("Invalid credentials provided.");
			}
		} else {
			throw new UserException("User not found.");
		}
	}

	public boolean validateUser(User user) throws ValidateUserException {
		if (user.getUserName() == null || user.getUserName().isEmpty()) {
			throw new ValidateUserException("Username cannot be empty.");
		}
		if (!user.getUserName().matches("^[A-Za-z ]{1,32}$")) {
			throw new ValidateUserException("Username should contain only alphabets.");
		}
		String userEmail = user.getEmailId();
		if (userEmail == null) {
			throw new ValidateUserException(AllConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		if (user.getPassword() == null || !user.getPassword().matches(AllConstants.PASSWORD_PATTERN)) {
			throw new ValidateUserException(AllConstants.PASSWORD_NOT_STRONG);
		}
		return true;
	}
}
