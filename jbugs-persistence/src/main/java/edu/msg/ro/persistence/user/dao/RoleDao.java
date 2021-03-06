package edu.msg.ro.persistence.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.entity.Permission;
import edu.msg.ro.persistence.entity.Role;

/**
 *
 * @author Alexa G, msg systems
 *
 */
@Stateless
public class RoleDao {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public void persistRole(final Role role) {
		em.persist(role);
	}

	public List<Role> getAllRoles() {
		final TypedQuery<Role> query = em.createNamedQuery(Role.FIND_ALL_ROLES, Role.class);
		return query.getResultList();
	}

	public Role getRoleByRoleName(final String roleName) {

		final Query q = em.createQuery("select r from Role r where r.roleName='" + roleName + "'", Role.class);
		try {
			final Role r = (Role) q.getSingleResult();
			System.out.println("IN ROLE DAO r: ");
			System.out.println(r.getRoleName());
			return (Role) q.getSingleResult();
		} catch (final NoResultException e) {
			return null;
		}
	}

	public List<Permission> getAllPermissionsOfARole(final String roleName) {

		final TypedQuery<Permission> query = em.createQuery(
				"select p from Permission p join p.roles rs WHERE rs.roleName=:roleName", Permission.class);
		query.setParameter("roleName", roleName);

		return query.getResultList();
	}

	public static void main(final String[] args) {

		final String roleName = "DEV";
		final RoleDao roleDao = new RoleDao();

		System.out.println("IN MAIN");
		final List<Permission> permissions = roleDao.getAllPermissionsOfARole(roleName);
		for (final Permission permission : permissions) {
			System.out.println(permission.getPermissionName());
		}
	}

}
