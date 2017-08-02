package edu.msg.ro.business.bug.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.bug.dto.mapper.BugDTOMapper;
import edu.msg.ro.persistance.bug.dao.BugDao;
import edu.msg.ro.persistence.entity.Bug;
import edu.msg.ro.persistence.entity.BugSeverity;
import edu.msg.ro.persistence.entity.BugStatus;
import edu.msg.ro.persistence.entity.User;

@Stateless
public class BugService {

	@EJB
	private BugDao bugDao;

	@EJB
	private BugDTOMapper bugMapper;

	public List<BugDTO> getAllBugs() {
		final List<Bug> allBugs = bugDao.getAllBugs();
		return allBugs.stream().map(bugEntity -> bugMapper.mapToDTO(bugEntity)).collect(Collectors.toList());
	}

	public boolean deleteBug(Long id) {
		bugDao.deleteBug(id);
		return true;
	}

	public void updateBug(BugDTO bugDTO) {
		Bug bug = bugDao.findById(bugDTO.getId());
		bug.setAssignedTo(bugDTO.getAssignedTo());
		bug.setDescription(bugDTO.getDescription());
		bug.setTitle(bugDTO.getTitle());
		bug.setSeverity(bugDTO.getSeverity());
		bug.setStatus(bugDTO.getStatus());
		bug.setTargetDate(bugDTO.getTargetDate());

		bugDao.updateBug(bug);
	}

	public void saveNewBug(String title, String description, Date targetDate, BugSeverity severity, String versionFound,
			User createdBy) {
		Bug bug = new Bug();
		bug.setStatus(BugStatus.NEW);
		bug.setTitle(title);
		bug.setDescription(description);
		bug.setTargetDate(targetDate);
		bug.setSeverity(severity);
		bug.setVersionFound(versionFound);
		bug.setCreatedBy(createdBy);
		bugDao.persistBug(bug);
	}

}
