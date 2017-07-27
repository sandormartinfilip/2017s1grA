package edu.msg.ro.persistence.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.user.entity.User;

/**
 * TODO: add javadoc create AbtractDao (findById generic)
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

	public User getUserByUserName(final String userName) {
		final TypedQuery<User> query = em.createNamedQuery(User.FIND_USER_BY_USERNAME, User.class);
		query.setParameter("username", userName);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User findById(final Long id) {
		return this.em.find(User.class, id);
	}

	public List<User> getAll() {
		final TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL_USERS, User.class);
		return query.getResultList();
	}

}
