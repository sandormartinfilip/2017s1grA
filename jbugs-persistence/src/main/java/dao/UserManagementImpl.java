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

public class UserManagementImpl implements UserManagementI {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager entityManager;

	// tranzactia se creaza automat

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void addRole(Role role) {
		entityManager.persist(role);
	}

	@Override
	public User updateUser(User user) {
		entityManager.merge(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Query q = entityManager.createQuery("select u from User u");
		return q.getResultList();
	}

	@Override
	public User getUserByUsername(String username) {
		Query q = entityManager.createQuery("select u from User u where u.username='" + username + "'");
		return (User) q.getSingleResult();
	}

	@Override
	public void deactivateUser(int id) {
		User user = entityManager.find(User.class, id);
		user.setActive(false);
		entityManager.flush();
	}

	@Override
	public void deleteRole(Role role) {
		entityManager.merge(role);
		entityManager.remove(role);

	}

	@Override
	public Role updateRole(Role role) {
		entityManager.merge(role);
		entityManager.flush();
		return role;
	}

	@Override
	public Role getRoleById(int id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public List<Role> getAllRoles() {
		Query q = entityManager.createQuery("select r from Role r");
		return q.getResultList();
	}

}
