package edu.msg.ro.persistence.user.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.msg.ro.persistence.entity.LoginHistory;

/**
 * 
 * @author petred
 *
 */
@Stateless
public class LoginHistoryDao {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public void persistLoginHistory(final LoginHistory loginHistory) {
		em.persist(loginHistory);
	}

}
