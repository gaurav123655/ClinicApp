//package com.cg.bookmydoctor.tests;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import com.cg.bookmydoctor.exception.UserException;
//import com.cg.bookmydoctor.exception.ValidateUserException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cg.bookmydoctor.BookMyDoctorApp2ApplicationTests;
//import com.cg.bookmydoctor.dao.IAdminDao;
//import com.cg.bookmydoctor.dto.Admin;
//import com.cg.bookmydoctor.exception.AdminException;
//import com.cg.bookmydoctor.exception.ValidateAdminException;
//import com.cg.bookmydoctor.serviceimpl.AdminServiceImpl;
//
//@SpringBootTest
//public class AdminTest extends BookMyDoctorApp2ApplicationTests {
//
//	@Autowired
//	private AdminServiceImpl adminService;  // Ensure that this is managed by Spring
//
//	@Autowired
//	private IAdminDao adminDao;  // Ensure that this is managed by Spring
//
//	@Before
//	public void setUp() {
//		// No need to manually instantiate adminService
//		adminService = new AdminServiceImpl(); // or mock if using Mockito
//
//	}
//
//	@Test
//	public void testAdminServiceImpl() {
//		assertTrue(adminService instanceof AdminServiceImpl);
//	}
//
//	@Test
//	public void testAddAdmin() throws AdminException, ValidateAdminException, ValidateUserException, UserException {
//		Admin admin = new Admin(1, "Shivani", "9876576879", "shivani@gmail.com", "Shivani@20");
//		admin = adminService.addAdmin(admin);
//		assertEquals(admin.getAdminId(), 1);
//		Admin admin2 = new Admin(2, "Sai priya", "9843576879", "saipriya@gmail.com", "S@ipriya20");
//		admin2 = adminService.addAdmin(admin2);
//		assertEquals(admin2.getAdminId(), 2);
//	}
//
//	@Test
//	public void testUpdateAdmin() throws AdminException, ValidateAdminException {
//		Admin admin = new Admin(1, "A Shivani", "9876543210", "shivani@gmail.com", "Shivani@20");
//		admin = adminService.updateAdmin(admin);
//		assertEquals(admin.getContactNumber(), "9876543210");
//	}
//
//	@Test
//	public void testRemoveAdmin() throws AdminException {
//		Admin admin = adminDao.findById(2).orElse(null);
//		if (admin != null) {
//			Admin deletedAdmin = adminService.removeAdmin(admin);
//			assertEquals(deletedAdmin, admin);
//		}
//	}
//
//	@Test
//	public void testViewAdmin() throws AdminException {
//		Admin admin = new Admin(1, "A Shivani", "9876543210", "shivani@gmail.com", "Shivani@20");
//		Admin adminGet = adminService.viewAdmin(admin);
//		assertNotNull(adminGet);
//	}
//
//	@After
//	public void tearDown() {
//		// No need to manually set adminService to null
//	}
//}
