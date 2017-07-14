package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import entities.Role;
import entities.User;

@Remote
public interface UserManagementI extends Serializable{

	void addUser(User user);

	User updateUser(User user);

	List<User> getAllUsers();

	User getUserByUsername(String username);

	void deactivateUser(int id);

	void addRole(Role role);

	void deleteRole(Role role);

	Role updateRole(Role role);

	Role getRoleById(int id);

	List<Role> getAllRoles();

}
