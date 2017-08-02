package edu.msg.ro.business.bug.service;

import java.util.List;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.persistance.bug.dao.BugDao;
import edu.msg.ro.persistence.entity.Bug;

public class BugServiceTest extends AbstractIntegrationTest {

	@EJB
	private BugService sut;

	@EJB
	private BugDao bugDao;

	@Test
	public void testGetAllBugs() throws JBugsBusinessException {
		List<Bug> bugList = bugDao.getAllBugs();
		System.out.println(bugList.get(0));
		System.out.println(bugList.get(1));
		Assert.assertEquals("All bugs test ", 5, bugList.size());
	}

	@Test
	public void testDeleteBug() throws JBugsBusinessException {
		List<Bug> bugListExpected = bugDao.getAllBugs();
		List<Bug> bugListActual = bugDao.getAllBugs();
		Bug bug = bugDao.findById((long) 3);
		bugListExpected.remove(bug);
		Assert.assertEquals(bugListExpected, bugListActual);
	}
}
