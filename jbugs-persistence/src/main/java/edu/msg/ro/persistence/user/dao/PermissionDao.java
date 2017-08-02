package edu.msg.ro.persistence.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.entity.Permission;

/**
 *
 * @author Alexa G, msg systems
 *
 */
@Stateless
public class PermissionDao {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public void persistPermission(final Permission permission) {
		em.persist(permission);
	}

	public List<Permission> getAllPermissions() {
		final TypedQuery<Permission> query = em.createNamedQuery(Permission.FIND_ALL_PERMISSIONS, Permission.class);
		return query.getResultList();
	}

	public List<Permission> getAllPermissionNames() {
		final TypedQuery<Permission> query = em.createNamedQuery(Permission.FIND_ALL_PERMISSIONS, Permission.class);
		return query.getResultList();
	}

	public List<Permission> getAllPermissionTypes() {
		final TypedQuery<Permission> query = em.createNamedQuery(Permission.FIND_ALL_PERMISSIONS, Permission.class);
		return query.getResultList();
	}
}
