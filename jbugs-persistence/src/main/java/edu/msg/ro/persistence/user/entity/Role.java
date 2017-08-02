package edu.msg.ro.persistence.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Role.FIND_ALL_ROLES, query = "SELECT r from Role r"),
		@NamedQuery(name = Role.FIND_ROLE_BY_ROLENAME, query = "SELECT r from Role r WHERE r.roleName=:roleName"), })

@Entity
public class Role extends AbstractEntity {

	public static final String FIND_ALL_ROLES = "Role.findAllRoles";
	public static final String FIND_ROLE_BY_ROLENAME = "Role.findRoleByRolename";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	@ManyToMany
	@JoinTable(name = "ROLE_PERMISSION", joinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_permission", referencedColumnName = "id"))
	private List<Permission> permissions;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(final String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(final List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(final List<Permission> permissions) {
		this.permissions = permissions;
	}
}