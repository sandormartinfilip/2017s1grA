package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Role;
import entities.User;

public class UserManagementImpl implements UserManagement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "JPA")
	private EntityManager em;

	@Override
	public void addUser(User user) {

		em.persist(user);

	}

	@Override
	public User updateUser(User user) {

		em.merge(user);

		return em.find(User.class, user.getId());

	}

	@Override
	public void deactivateUser(int id) {
		User user = em.find(User.class, id);
		user.setActiv(false);
		em.flush();
	}

	@Override
	public List<User> getAllUsers() {
		Query q = em.createQuery("select u from User u");
		return q.getResultList();
	}

	@Override
	public User getUserForUsername(String username) {
		Query q = em.createQuery("select u from User u where u.username= '" + username + "'");
		return (User) q.getSingleResult();
	}

	@Override
	public void addRole(Role role) {

		em.persist(role);

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
	public Role getRoleForId(int id) {
		return em.find(Role.class, id);
	}

	@Override
	public List<Role> getAllRoles() {
		Query q = em.createQuery("select r from Role r");
		return q.getResultList();
	}

}
