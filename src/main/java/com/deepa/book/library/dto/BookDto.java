package com.deepa.book.library.dto;

import java.util.Date;

public class BookDto {
	
	private String title;
	private long categoryId;
	private Date publicationDate;
	private Integer copiesOwned;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getCopiesOwned() {
		return copiesOwned;
	}

	public void setCopiesOwned(Integer copiesOwned) {
		this.copiesOwned = copiesOwned;
	}

	
	
	

}
