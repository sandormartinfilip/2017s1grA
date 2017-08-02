package edu.msg.ro.persistence.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.user.entity.User;

/**
 * 
 * @author Andrei Floricel, msg systems ag
 *
 */
@Stateless
public class UserDao {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public void persistUser(final User user) {
		em.persist(user);
	}

	public List<User> getUserByLastName(final String lastName) {
		final TypedQuery<User> query = em.createNamedQuery(User.FIND_USER_BY_LASTNAME, User.class);
		query.setParameter("lastName", lastName);

		return query.getResultList();
	}

	public User findById(final Long id) {
		return this.em.find(User.class, id);
	}

	public List<User> getUserForUsername(String username) {
		Query q = em.createQuery("select u from User u where u.username='" + username + "'", User.class);
		return q.getResultList();

	}

	public User getUserByUsername(String username) {
		Query q = em.createQuery("select u from User u where u.username='" + username + "'", User.class);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<User> getAll() {
		final TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL_USERS, User.class);
		return query.getResultList();
	}

	public void deleteUser(Long id) {

		User user = em.find(User.class, id);
		em.remove(user);
	}

	public User updateUser(User user) {

		em.merge(user);
		return user;
	}

}
