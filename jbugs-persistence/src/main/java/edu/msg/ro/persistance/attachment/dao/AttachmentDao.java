package edu.msg.ro.persistance.attachment.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.entity.Attachment;

/**
 * 
 * @author petred
 *
 */
@Stateless
public class AttachmentDao {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	public void persistUser(final Attachment attachment) {
		em.persist(attachment);
	}

	public Attachment findAttachmentById(Long id) {
		return this.em.find(Attachment.class, id);
	}

	public List<Attachment> getAllAttachments() {
		final TypedQuery<Attachment> query = em.createNamedQuery(Attachment.FIND_ALL_ATTACHMENTS, Attachment.class);
		return query.getResultList();
	}

	public void deleteAttachment(Long id) {

		Attachment attachment = em.find(Attachment.class, id);
		em.remove(attachment);
	}

}
