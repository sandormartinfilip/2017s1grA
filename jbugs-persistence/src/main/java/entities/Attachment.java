package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ATTACHMENT")
public class Attachment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Attachment")
	private int idAttachment;
	
	@Column(name = "ID_Bug")
	private int idBug;
	
	@Column(name = "Attachment")
	private String attachment;
	
	public Attachment(){
		
	}

	public Attachment(int idBug, String attachment) {
		super();
		this.idBug = idBug;
		this.attachment = attachment;
	}

	public int getIdAttachment() {
		return idAttachment;
	}

	public void setIdAttachment(int idAttachment) {
		this.idAttachment = idAttachment;
	}

	public int getIdBug() {
		return idBug;
	}

	public void setIdBug(int idBug) {
		this.idBug = idBug;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	

}
