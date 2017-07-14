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

	void deactivateUser(int id);

	List<User> getAllUsers();

	User getUserForUsername(String username);

	void addRole(Role role);
	
	void removeRole(Role role);
	
	Role updateRole(Role role);
	
	Role getRoleForId(int id);
	
	List<Role> getAllRoles();

}
