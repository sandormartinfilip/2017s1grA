package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import entities.Role;
import entities.User;

@Remote
public interface UserManagement extends Serializable{
	public void addUser(User user);
	
	public User updateUser(User user);
	
	public void deactivateUser(int id);
	
	List<User> getAllUsers();	
	
	User getUserByUsername(String username);
	
	public void addRole(Role role);
	
	void removeRole(Role role);
	
	Role updateRole(Role role);
	
	List<Role> getAllRoles();
	
	Role getRoleForId(int id);
}
