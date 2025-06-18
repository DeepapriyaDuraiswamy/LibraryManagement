package com.deepa.book.library.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "book", schema = "public")
public class BookEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "book_category_id_fkey"))
    private CategoryEntity category;*/
    
    @Column(name = "category_id")
    private int categoryId;
    
    
	@Column(name = "publication_date")
    private LocalDate publicationDate;

	@Column(name = "copies_owned")
    private Long copiesOwned;
	
    // Getters and Setters

	

	public void setId(Long id) {
		this.id = id;
	}

	    public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

		public Long getId() {
		return id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

	public Long getCopiesOwned() {
		return copiesOwned;
	}

	public void setCopiesOwned(Long copiesOwned) {
		this.copiesOwned = copiesOwned;
	}

   

}
