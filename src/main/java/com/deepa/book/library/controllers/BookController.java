package com.deepa.book.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepa.book.library.dto.BookDto;
import com.deepa.book.library.service.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	@PostMapping("/saveBook")
	public BookDto saveBook(@RequestBody BookDto request) {
		System.out.println("Title" + request.getTitle());
		System.out.println("Title2" + request.getCategoryId());
		System.out.println("Title3" + request.getPublicationDate());
		System.out.println("Title4" + request.getCopiesOwned());
	    return bookService.saveBook(request);
	}
	
	@PostMapping("/books")
    public List<BookDto> getBooksByTitle(@RequestBody BookDto request) {
        return bookService.searchBooksByTitle(request.getTitle());
    }

}
