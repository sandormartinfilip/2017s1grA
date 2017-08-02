// package edu.msg.ro.business.notification.service;
//
// import java.util.List;
//
// import javax.ejb.EJB;
//
// import org.jboss.arquillian.junit.InSequence;
// import org.junit.Assert;
// import org.junit.Test;
//
// import edu.msg.ro.business.AbstractIntegrationTest;
// import edu.msg.ro.business.user.dto.UserDTO;
// import edu.msg.ro.persistence.notification.dao.NotificationDao;
//
// public class NotificationServiceTest extends AbstractIntegrationTest {
//
// @EJB
// private NotificationService sut;
//
// @EJB
// private NotificationDao notificationDao;
//
// @Test
// @InSequence(1)
// public void testSaveNewNotification_Successful() {
// final String FIRSTNAME = "Robert";
// final String LASTNAME = "Smith";
//
// // ARRANGE
// List<UserDTO> userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("No user should exist!", userList.size(), 0);
//
// // ACT
//
// sut.addUser(FIRSTNAME, LASTNAME, "+40757778737", "email@msggroup.com");
//
// // ASSERT
// userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("Exactly one user should be persisted", userList.size(),
// 1);
// // Assert.assertTrue(userList.get(0).isActive());
//
// // ADD NEW USER WITH SAME NAME AND DIFFERENT EMAIL ADDRESS
//
// // ARRANGE
// userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("One User should exist!", userList.size(), 1);
//
// // ACT
//
// sut.addUser(FIRSTNAME, LASTNAME, "+40757778737", "email1@msggroup.com");
//
// // ASSERT
// userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("Exactly two users should be persisted", userList.size(),
// 2);
// // Assert.assertTrue(userList.get(0).isActive());
//
// // ADD NEW USER WITH WRONG EMAIL BUT SAME NAME
//
// // ARRANGE
// userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("TWO USERS should exist!", userList.size(), 2);
//
// // ACT
// // email must be *something*@msggroup.com
// sut.addUser(FIRSTNAME, LASTNAME, "+40757778737", "email@yahoo.com");
//
// // ASSERT
// userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("Exactly two users should be persisted", userList.size(),
// 2);
// // Assert.assertTrue(userList.get(0).isActive());
//
// // ADD NEW USER WITH WRONG PHONE NUMBER BUT SAME NAME
//
// // ARRANGE
// userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("TWO USERS should exist!", userList.size(), 2);
//
// // ACT
// // phone number must start with "+40" and its length should be 12
// // or must start with "+49" and its length must be between 5 and 14
// sut.addUser(FIRSTNAME, LASTNAME, "+407577787373", "email@yahoo.com");
// sut.addUser(FIRSTNAME, LASTNAME, "+40757778", "email@yahoo.com");
// sut.addUser(FIRSTNAME, LASTNAME, "+4975", "email@yahoo.com");
// sut.addUser(FIRSTNAME, LASTNAME, "+4075777873731235", "email@yahoo.com");
// sut.addUser(FIRSTNAME, LASTNAME, "+407577787a7", "email@yahoo.com");
// sut.addUser(FIRSTNAME, LASTNAME, "+4975777877777", "email2@msggroup.com");
//
// // ASSERT
// userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("Exactly THREE users should be persisted",
// userList.size(), 3);
// // Assert.assertTrue(userList.get(0).isActive());
//
// }
//
// // @Test
// // @InSequence(2)
// // public void testSaveNewUser_validateState() {
// //
// // final List<UserDTO> userList = sut.getUserByLastName("Smith");
// //
// // Assert.assertTrue("TODO: check Arquillian docu for create/recreate
// // dbstrategies", true);
// // }
//
// // @Test
// // @InSequence(3)
// // public void testGetUserForUsername() {
// //
// // List<User> userList = userDao.getUserForUsername("SmithJ");
// // Assert.assertEquals("ONE user should exist!", userList.size(), 1);
// //
// // }
// //
// @Test
// @InSequence(2)
// public void testDeleteUser() {
//
// final String FIRSTNAME = "Robert";
// final String LASTNAME = "Sanchez";
//
// // ARRANGE
// sut.addUser(FIRSTNAME, LASTNAME, "+40757778737",
// "robert.sanchez@msggroup.com");
//
// final List<UserDTO> userList = sut.getUserByLastName(LASTNAME);
// Assert.assertEquals("There should be a user with name " + LASTNAME + "!",
// userList.size(), 1);
// Assert.assertTrue("The user should be active", userList.get(0).isActive());
//
// // ACT
// // sut.deleteUser(userList.get(0).getId());
// sut.changeUserStatus(userList.get(0).getUsername(), false);
//
// // ASSERT
// final UserDTO deletedUser =
// sut.getUserByUsername(userList.get(0).getUsername());
// Assert.assertNotNull("Deletion is only logical, not physical!", deletedUser);
// Assert.assertFalse("User should be deactivated", deletedUser.isActive());
// }
// //
// // @Test(expected = ObjectNotFoundException.class)
// // public void testDeleteUser_throwsObjectNotFoundException() throws
// // JBugsBusinessException {
// //
// // // ARRANGE
// // final User nonExistinguser = userDao.findById(3000L);
// // Assert.assertNull("User should not exist", nonExistinguser);
// //
// // // ACT
// // sut.deleteUser(3000L);
// //
// // // ASSERT
// // // throws ObjectNotFoundException
// // }
//
// }
