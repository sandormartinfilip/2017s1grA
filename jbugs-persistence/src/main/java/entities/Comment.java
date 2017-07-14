package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "COMMENT")
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Comment")
	private int idComment;

	@Column(name = "ID_User")
	private int idUser;
	
	@Column(name = "ID_Bug")
	private int idBug;
	
	@Column(name = "ID_Comment_Text")
	private String commentText;
	
	@Column(name = "ID_Comment_Date")
	private Timestamp commentDate;
	
	public Comment(){
		
	}
	
	public Comment(int idUser, int idBug, String commentText, Timestamp commentDate) {
		super();
		this.idUser = idUser;
		this.idBug = idBug;
		this.commentText = commentText;
		this.commentDate = commentDate;
	}



	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdBug() {
		return idBug;
	}

	public void setIdBug(int idBug) {
		this.idBug = idBug;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
