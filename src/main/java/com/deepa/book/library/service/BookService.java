package com.deepa.book.library.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	     
	    BookEntity savedEntity = bookRepository.save(entity);
	    return convertEntityToDto(savedEntity);
	}

	public List<BookDto> searchBooksByTitle(String title) {
		
       List<BookDto> res = new ArrayList<BookDto>(); 
		bookRepository.findByTitle(title).forEach((entity) -> {
			
			res.add(convertEntityToDto(entity));
		});
		return res;
    }
	
	private BookEntity convertDtoToEntity(BookDto bookDto) {
	    BookEntity entity = new BookEntity();
	    entity.setTitle(bookDto.getTitle());
	    entity.setCategoryId(bookDto.getCategoryId());
	    entity.setCopiesOwned(bookDto.getCopiesOwned());
	    if (bookDto.getPublicationDate() != null) {
	        entity.setPublicationDate(convertDateToLocalDate(bookDto.getPublicationDate()));
	    }
	    
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
