package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPermission")
	private int id;
	
	@Column(nullable = false, unique = true, length=50)
	private String permissionName;
	
	private String description;
	
	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles;
	
	public Permission(){
		
	}

	public Permission(String permissionName, String description) {
		super();
		this.permissionName = permissionName;
		this.description = description;
	}

	public int getIdPermission() {
		return id;
	}

	public void setIdPermission(int idPermission) {
		this.id = idPermission;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
