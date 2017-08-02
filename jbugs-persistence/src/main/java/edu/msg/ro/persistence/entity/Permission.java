package edu.msg.ro.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Permission.FIND_ALL_PERMISSIONS, query = "SELECT p from Permission p"),
		@NamedQuery(name = Permission.FIND_ALL_PERMISSION_NAMES, query = "SELECT p from Permission p WHERE p.permissionName = :permissionName"),
		// @NamedQuery(name = Permission.FIND_ALL_PERMISSIONS_OF_ROLE, query =
		// "SELECT p.permissionName FROM Permission p, role_permission rp, Role
		// r WHERE p.id=:rp.id_permission and rp.id_role=:r.ID;"),
		@NamedQuery(name = Permission.FIND_ALL_PERMISSION_TYPES, query = "SELECT p from Permission p WHERE p.permissionType = :permissionType"), })
/**
 *
 * @author Alexa G, msg systems
 *
 *         Permissions describe the capacity of a User to fulfill certain
 *         actions/tasks. A user can perform a certain action iff it has a
 *         permission/right.
 *
 */
@Entity
public class Permission extends AbstractEntity {

	public static final String FIND_ALL_PERMISSIONS = "Permission.findAllPermissions";
	public static final String FIND_ALL_PERMISSION_NAMES = "Permission.findAllPermissionNames";
	public static final String FIND_ALL_PERMISSION_TYPES = "Permission.findAllPermissionTypes";
	public static final String FIND_ALL_PERMISSIONS_OF_ROLE = "Permission.findAllPermissionsOfRole";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String permissionName;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private PermissionManagementType permissionType;

	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(final String permissionName) {
		this.permissionName = permissionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public PermissionManagementType getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(final PermissionManagementType permissionType) {
		this.permissionType = permissionType;
	}

}