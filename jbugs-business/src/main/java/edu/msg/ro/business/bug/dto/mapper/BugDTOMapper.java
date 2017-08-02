package edu.msg.ro.business.bug.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.persistence.entity.Bug;

@Stateless
public class BugDTOMapper {

	public BugDTO mapToDTO(final Bug bugEntity) {

		final BugDTO bugDTO = new BugDTO();
		bugDTO.setId(bugEntity.getId());
		bugDTO.setDescription(bugEntity.getDescription());
		bugDTO.setSeverity(bugEntity.getSeverity());
		bugDTO.setStatus(bugEntity.getStatus());
		bugDTO.setTargetDate(bugEntity.getTargetDate());
		bugDTO.setTitle(bugEntity.getTitle());
		bugDTO.setVersionFixed(bugEntity.getVersionFixed());
		bugDTO.setVersionFound(bugEntity.getVersionFound());
		bugDTO.setSeverity(bugEntity.getSeverity());
		bugDTO.setAssignedTo(bugEntity.getAssignedTo());
		bugDTO.setCreatedBy(bugEntity.getCreatedBy());

		return bugDTO;
	}

}
