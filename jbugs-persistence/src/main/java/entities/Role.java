package entities;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Access(AccessType.FIELD)
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRole")
	private int id;

	@Column(nullable = false, unique = true, length = 50)
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	@ManyToMany
	@JoinTable(
			name="ROLE_PERMISSION",
			joinColumns=@JoinColumn(name="id_role", referencedColumnName="idRole"),
			inverseJoinColumns=@JoinColumn(name="id_permission", referencedColumnName="idPermission"))
	List<Permission> permissions;

	public Role() {

	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int idRole) {
		this.id = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	
}
