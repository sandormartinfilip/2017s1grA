package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.dto.AbstractDTO;
import edu.msg.ro.persistence.user.entity.PermissionManagementType;

public class PermissionDTO extends AbstractDTO {

	private String permissionName;

	private String description;

	private PermissionManagementType permissionType;

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

	@Override
	public String toString() {
		return "PermissionDTO [permissionName=" + permissionName + ", description=" + description + "]";
	}

}
