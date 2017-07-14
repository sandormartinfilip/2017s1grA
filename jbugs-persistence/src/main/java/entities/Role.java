package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRole")
	private int id;
	@Column(length=50,nullable=false)
	private String roleName;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	@ManyToMany
	@JoinTable(name="ROLE_PERMISSION", joinColumns=@JoinColumn(name="id_role", referencedColumnName="idRole"), inverseJoinColumns=@JoinColumn(name="id_permirrion", referencedColumnName="idPermission"))
	private List<Permission> permissions;
	
	public List<Permission> getPermissions() {
		return permissions;
	}


	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Role() {
		super();
	}
	

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
