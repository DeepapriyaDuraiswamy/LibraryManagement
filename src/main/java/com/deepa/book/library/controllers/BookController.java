package com.deepa.book.library.controllers;

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
	    return bookService.saveBook(request);
	}

}
