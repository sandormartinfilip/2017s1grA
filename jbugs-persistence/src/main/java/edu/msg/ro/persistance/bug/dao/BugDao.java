package edu.msg.ro.persistance.bug.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.entity.Bug;

/**
 * 
 * @author homsif
 *
 */

@Stateless
public class BugDao {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public void persistBug(final Bug bug) {
		em.persist(bug);
	}

	public Bug findById(final Long id) {
		return this.em.find(Bug.class, id);
	}

	public List<Bug> getAllBugs() {
		final TypedQuery<Bug> query = em.createNamedQuery(Bug.FIND_ALL_BUGS, Bug.class);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	public void deleteBug(Long id) {
		Bug bug = em.find(Bug.class, id);
		em.remove(bug);
	}

	public Bug updateBug(Bug bug) {
		em.merge(bug);
		return bug;
	}

	/*
	 * public List<Bug> getBugsBySeverity(BugSeverity bugSeverity) {
	 * 
	 * }
	 */

}
