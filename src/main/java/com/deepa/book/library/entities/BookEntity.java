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
    private Long categoryId;
    
    
	@Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "copies_owned", nullable = false)
    private Integer copiesOwned;

    // Getters and Setters

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setId(Long id) {
		this.id = id;
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

    /*public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
*/
    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getCopiesOwned() {
        return copiesOwned;
    }

    public void setCopiesOwned(Integer copiesOwned) {
        this.copiesOwned = copiesOwned;
    }

}
