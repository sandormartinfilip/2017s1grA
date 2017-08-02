package edu.msg.ro.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Attachment.FIND_ALL_ATTACHMENTS, query = "SELECT a from Attachment a") })

@Entity
public class Attachment extends AbstractEntity {

	public static final String FIND_ALL_ATTACHMENTS = "Attachment.findAllAttachments";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "bugId", referencedColumnName = "id")
	private Bug bugId;

	@Lob
	private byte[] attachment;

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
