package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Role;
import entities.User;

public class UserManagementImpl implements UserManagement {
	
	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;


	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public void addRole(Role role) {
		em.persist(role);
	}

	@Override
	public User updateUser(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void deactivateUser(int id) {
		User user = em.find(User.class, id);
		user.setActive(false);	
	}

	@Override
	public List<User> getAllUsers() {
		Query q = em.createQuery("select u from User u");
		return q.getResultList();
	}

	@Override
	public User getUserByUsername(String username) {
		Query q = em.createQuery("select u from User u WHERE u.username = '" + username +"'");
		return (User) q.getSingleResult();
	}

	@Override
	public void removeRole(Role role) {
		em.merge(role);
		em.remove(role);
	}

	@Override
	public Role updateRole(Role role) {
		em.merge(role);
		em.flush();
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		Query q = em.createQuery("select r from Role r");
		return q.getResultList();
	}

	@Override
	public Role getRoleById(int id) {
		return em.find(Role.class, id);
	}

}
