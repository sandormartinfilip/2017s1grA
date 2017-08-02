package edu.msg.ro.persistence.user.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public List<LoginHistory> getLoginHistoryByUsername(final String userName) {
		final TypedQuery<LoginHistory> query = em.createNamedQuery(LoginHistory.FIND_LOGINHISTORY_BY_USERNAME,
				LoginHistory.class);
		query.setParameter("userName", userName);
		query.setMaxResults(5);

		return query.getResultList();

	}

	public void tryToLogin(String userName, boolean succes) {
		LoginHistory loginHistory = new LoginHistory();

		loginHistory.setLoginDate(new Timestamp(System.currentTimeMillis()));
		loginHistory.setUsername(userName);
		loginHistory.setSucces(succes);

		em.persist(loginHistory);
	}

}
