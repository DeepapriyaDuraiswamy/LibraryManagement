package com.deepa.book.library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "test_table", schema = "public")
public class HelloEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming an ID column may be added later
	@Column(name = "id", nullable = false, unique = true)
	private Long id; // Add an ID column if needed (remove if unnecessary)

	@Column(name = "test_column1", length = 255) // Default length for varchar is 255
	private String testColumn1;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestColumn1() {
		return testColumn1;
	}

	public void setTestColumn1(String testColumn1) {
		this.testColumn1 = testColumn1;
	}
}
