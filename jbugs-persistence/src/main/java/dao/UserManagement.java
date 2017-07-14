package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.Role;
import entities.User;

@Remote
public interface UserManagement {
	
	public void addUser (User user);
	
	User updateUser (User user);
	
	void deactivateUser(int id);
	
	List<User> getAllUsers(); 
	
	User getUserByUsername(String username);
	
	public void addRole (Role role);
	
	void removeRole(Role role);
	
	Role updateRole(Role role);
	
	List<Role> getAllRoles();
	
	Role getRoleById(int id);

}
