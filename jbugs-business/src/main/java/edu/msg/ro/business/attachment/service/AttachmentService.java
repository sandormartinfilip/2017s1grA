package edu.msg.ro.business.attachment.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.persistance.attachment.dao.AttachmentDao;

/**
 * 
 * @author petred
 *
 */
@Stateless
public class AttachmentService {

	@EJB
	private AttachmentDao attachmentDao;

	// TODO

	/*
	 * public void saveNewAttachment(final byte[] attachmentFile, final Long id)
	 * { final Attachment attachment = new Attachment();
	 * 
	 * attachment.setAttachment(attachment); }
	 */

}
