package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "PERMISSION")
public class Permission implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Permission")
	private int idPermission;
	
	@Column(name = "Permission_Name")
	private String permissionName;
	
	@Column(name = "Description")
	private String description;
	
	@ManyToMany (mappedBy = "permissions")
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Permission(){
		
	}
	
	public Permission(String permissionName, String description) {
		super();
		this.permissionName = permissionName;
		this.description = description;
	}



	public int getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(int idRolePermission) {
		this.idPermission = idRolePermission;
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
		

}
