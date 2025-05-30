package com.deepa.book.library.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepa.book.library.dto.BookDto;
import com.deepa.book.library.entities.BookEntity;
import com.deepa.book.library.repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	public BookRepository bookRepository;
	
	public BookDto saveBook(BookDto bookDto) {
	    BookEntity entity = convertDtoToEntity(bookDto);
	    long threadId = Thread.currentThread().getId();
        System.out.println("Current thread ID: " + threadId);
        
	    BookEntity savedEntity = bookRepository.save(entity);
	    return convertEntityToDto(savedEntity);
	}

	private BookEntity convertDtoToEntity(BookDto bookDto) {
	    BookEntity entity = new BookEntity();
	    entity.setTitle(bookDto.getTitle());
	    entity.setCategoryId(bookDto.getCategoryId());

	    if (bookDto.getPublicationDate() != null) {
	        entity.setPublicationDate(convertDateToLocalDate(bookDto.getPublicationDate()));
	    }

	    entity.setCopiesOwned(bookDto.getCopiesOwned());
	  return entity;
	}

	private LocalDate convertDateToLocalDate(Date date) {
	    return date.toInstant()
	               .atZone(ZoneId.systemDefault())
	               .toLocalDate();
	}

	private BookDto convertEntityToDto(BookEntity entity) {
	    BookDto dto = new BookDto();
	    dto.setTitle(entity.getTitle());
	    dto.setCategoryId(entity.getCategoryId());
	    dto.setCopiesOwned(entity.getCopiesOwned());
	    dto.setPublicationDate(convertLocalDateToDate(entity.getPublicationDate()));
	    return dto;
	}

	private Date convertLocalDateToDate(LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}


}
