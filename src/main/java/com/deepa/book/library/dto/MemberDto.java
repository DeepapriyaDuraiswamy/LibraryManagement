package com.deepa.book.library.dto;

import java.util.Date;

public class MemberDto {

	    private Integer id;
	    private String firstName;
	    private String lastName;
	    private Date joinedDate;
	    private Integer activeStatusId;

	    // Getters and Setters
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	   
	    public Date getJoinedDate() {
			return joinedDate;
		}

		public void setJoinedDate(Date joinedDate) {
			this.joinedDate = joinedDate;
		}

		public Integer getActiveStatusId() {
	        return activeStatusId;
	    }

	    public void setActiveStatusId(Integer activeStatusId) {
	        this.activeStatusId = activeStatusId;
	    }

		


}
