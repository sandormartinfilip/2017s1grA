package edu.msg.ro.persistence.user.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String commentText;

	@Column
	private Timestamp commentDate;

	@Override
	public Long getId() {
		return this.id;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(final String commentText) {
		this.commentText = commentText;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(final Timestamp commentDate) {
		this.commentDate = commentDate;
	}

}
