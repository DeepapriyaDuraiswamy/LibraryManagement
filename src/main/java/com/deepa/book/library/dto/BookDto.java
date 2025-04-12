package com.deepa.book.library.dto;

import java.util.Date;

public class BookDto {
	
	private String title;
	private int categoryId;
	private Date publicationDate;
	private long copiesOwned;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public long getCopiesOwned() {
		return copiesOwned;
	}

	public void setCopiesOwned(long copiesOwned) {
		this.copiesOwned = copiesOwned;
	}

		
	

}
