package com.cg.bookmydoctor.serviceimpl;

import java.util.Optional;

import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.exception.ValidateUserException;
import com.cg.bookmydoctor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.ValidateAdminException;
import com.cg.bookmydoctor.service.IAdminService;
import com.cg.bookmydoctor.util.AllConstants;
import com.cg.bookmydoctor.dao.IAdminDao;
import com.cg.bookmydoctor.dao.IUserDao; // Add this line to use userDao

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserDao userDao; // Add this to save User

	@Override
	public Admin addAdmin(final Admin admin) throws AdminException, ValidateAdminException, UserException, ValidateUserException {
		validateAdmin(admin); // Validate admin-specific details
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if (adminDb.isPresent()) {
			throw new AdminException("Admin already exists with ID: " + admin.getAdminId());
		} else {
			Admin savedAdmin = adminDao.save(admin);
			createUserForAdmin(savedAdmin);
			return savedAdmin;
		}
	}

	private void createUserForAdmin(Admin admin) throws UserException, ValidateUserException {
		User user = new User();
		user.setUserName(admin.getAdminName());
		user.setEmailId(admin.getAdminEmail());
		user.setPassword(admin.getPassword());

		userService.validateUser(user); // Correctly calling validateUser from userService
		userDao.save(user); // Saving user after validation
	}

	@Override
	public Admin removeAdmin(final Admin admin) throws AdminException {
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if (!adminDb.isPresent()) {
			throw new AdminException("Admin with ID: " + admin.getAdminId() + " doesn't exist to delete");
		} else {
			adminDao.deleteById(admin.getAdminId());
			return admin;
		}
	}

	@Override
	public Admin viewAdmin(final Admin admin) throws AdminException {
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if (adminDb.isPresent()) {
			return adminDb.get();
		} else {
			throw new AdminException("Admin doesn't exist with ID: " + admin.getAdminId());
		}
	}

	@Override
	public Admin updateAdmin(final Admin admin) throws AdminException, ValidateAdminException {
		validateAdmin(admin);
		Optional<Admin> adminDb = adminDao.findById(admin.getAdminId());
		if (!adminDb.isPresent()) {
			throw new AdminException("Admin doesn't exist with ID: " + admin.getAdminId());
		} else {
			return adminDao.save(admin);
		}
	}


	private void validateAdmin(final Admin admin) throws ValidateAdminException {
		if (admin == null) {
			throw new ValidateAdminException("Admin object cannot be null");
		}

		String name = admin.getAdminName();
		if (name == null || !name.matches(AllConstants.NAME_PATTERN)) {
			throw new ValidateAdminException(AllConstants.ADMIN_CANNOT_BE_EMPTY);
		}

		String contactNumber = admin.getContactNumber();
		if (contactNumber == null || !contactNumber.matches(AllConstants.PHONENUMBER_PATTERN)) {
			throw new ValidateAdminException(AllConstants.EMPTY_PHONENUMBER);
		}

		String adminEmail = admin.getAdminEmail();
		System.out.println("admin email id: " + adminEmail);
		if (adminEmail == null) {
			throw new ValidateAdminException(AllConstants.EMAIL_CANNOT_BE_EMPTY);
		}

		String password = admin.getPassword();
		if (password == null || !password.matches(AllConstants.PASSWORD_PATTERN)) {
			throw new ValidateAdminException(AllConstants.PASSWORD_NOT_STRONG);
		}
	}
}
