package com.pfyuit.myjavaee.model.hibernate;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity model for JPA/Hibernate.
 * @author yupengfei
 */
@Entity
@Table(name = "blog")
public class BlogModel {

	@Id
	@Column(name = "blogid")
	private int blogid;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "createDate")
	private Timestamp createDate;

	@Column(name = "lastModified")
	private Timestamp lastModified;

	@Column(name = "content")
	private String content;

	@Column(name = "isOriginal")
	private String isOriginal;

	@Column(name = "readCount")
	private Long readCount;

	@ManyToOne(targetEntity = CategoryModel.class)
	@JoinColumn(name = "categoryid")
	private CategoryModel category;

	@OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
	private List<CommentModel> comments;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String isOriginal() {
		return isOriginal;
	}

	public void setOriginal(String isOriginal) {
		this.isOriginal = isOriginal;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public List<CommentModel> getComments() {
		return comments;
	}

	public void setComments(List<CommentModel> comments) {
		this.comments = comments;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getIsOriginal() {
		return isOriginal;
	}

	public void setIsOriginal(String isOriginal) {
		this.isOriginal = isOriginal;
	}

}
