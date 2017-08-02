package edu.msg.ro.persistence.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.user.entity.Permission;
import edu.msg.ro.persistence.user.entity.Role;

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

	public String try1 = "select p from Permission p, Role r where r.roleName = p.roles.roleName AND r.roleName=:roleName";

	public String try2 = "select p from Permission p join p.roles rs WHERE rs.roleName=:roleName";

	public String try3 = "select p from Permission p join p.roles rs join rs.roles WHERE rs.roleName=:roleName";

	public String try4 = "select p from Permission p join p.roles r WHERE r.roleName in :roleName";

	public List<Permission> getAllPermissionsOfARole(final String roleName) {

		final TypedQuery<Permission> query = em.createQuery(try2, Permission.class);
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