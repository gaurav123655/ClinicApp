//package com.cg.bookmydoctor.tests;
//
//import static org.junit.Assert.assertEquals;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cg.bookmydoctor.BookMyDoctorApp2ApplicationTests;
//import com.cg.bookmydoctor.dto.User;
//import com.cg.bookmydoctor.exception.UserException;
//import com.cg.bookmydoctor.exception.ValidateUserException;
//import com.cg.bookmydoctor.serviceimpl.UserServiceImpl;
//
//@SpringBootTest
//public class UserTest extends BookMyDoctorApp2ApplicationTests {
//
//
//	@Autowired
//	UserServiceImpl userservice;
//
//	@Before
//	public void setUp() {
//		userservice = new UserServiceImpl();
//	}
//
//	@Test
//	void testUserServiceImpl() {
//		assertTrue(userservice instanceof UserServiceImpl);
//	}
//
//	@Test
//    void testAddUser() throws UserException, ValidateUserException{
//		User user = new User(1, "Ruchi", "Ruchi@1206", "Doctor");
//		user = userservice.addUser(user);
//		assertEquals(user.getUserId(), 1);
//
//		User user1 = new User(2, "Raghu", "Raghu@2702", "Patient");
//		user1 = userservice.addUser(user1);
//		assertEquals(user1.getUserId(), 2);
//	}
//
//	@Test
//	void testUpdateUser() throws ValidateUserException, UserException {
//		User user = new User(1, "Ruchitha", "Ruchi@1206", "Doctor");
//		user = userservice.updateUser(user);
//		assertEquals(user.getUserName(), "Ruchitha");
//	}
//
//	@Test
//	void testRemoveUser() throws ValidateUserException, UserException {
//		User user = new User(1, "Ruchi", "Ruchi@1206", "Doctor");
//		User removeuser = userservice.removeUser(user);
//		assertEquals(user.getUserId(), removeuser.getUserId());
//	}
//
//	@Test
//	void testGetUser() throws UserException {
//		User user = new User(1, "Ruchi", "Ruchi@1206", "Doctor");
//		User getuser = userservice.getUser(user);
//		assertEquals(user.getUserId(),1);
//	}
//
//	@After
//	public void setDown() {
//		userservice = null;
//	}
//}