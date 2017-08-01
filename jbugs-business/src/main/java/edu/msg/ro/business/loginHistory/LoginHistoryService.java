package edu.msg.ro.business.loginHistory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.persistence.user.dao.LoginHistoryDao;

/**
 * 
 * @author petred
 *
 */
@Stateless
public class LoginHistoryService {

	@EJB
	private LoginHistoryDao loginHistoryDao;

	@EJB
	private LoginHistoryDTOMapper loginHistoryMapper;

}
