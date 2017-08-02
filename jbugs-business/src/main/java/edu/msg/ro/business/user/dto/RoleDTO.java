package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.dto.AbstractDTO;

public class RoleDTO extends AbstractDTO {

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDTO [roleName=" + roleName + "]";
	}

}
