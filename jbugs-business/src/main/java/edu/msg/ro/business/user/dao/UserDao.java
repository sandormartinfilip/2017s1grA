package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.user.entity.User;

@Dependent
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

	public List<User> getUserByUserName(final String userName) {
		final TypedQuery<User> query = em.createNamedQuery(User.FIND_USER_BY_USERNAME, User.class);
		query.setParameter("username", userName);
		return query.getResultList();
	}

	public User findById(final Long id) {
		return this.em.find(User.class, id);
	}

	public List<User> getAll() {
		final TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL_USERS, User.class);
		return query.getResultList();
	}
}
