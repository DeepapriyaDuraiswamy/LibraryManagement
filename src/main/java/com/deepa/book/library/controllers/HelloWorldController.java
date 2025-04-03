package com.deepa.book.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepa.book.library.dto.HelloDto;
import com.deepa.book.library.entities.HelloEntity;
import com.deepa.book.library.service.HelloService;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	@Autowired
	public HelloService helloService;

	@GetMapping("/hello")
	public String greetings() {

		return "Hello World";
	}

	@GetMapping("/get")
	public List<HelloDto> getTableData() {
		return helloService.getTableData();
	}

	@GetMapping("/get/{id}")
	public List<String> getTableData(@PathVariable Long id) {
		return helloService.getTableDataById(id);
	}

	@GetMapping("/getTableData")
	public List<String> getTableDataWithQuery() {
		return helloService.getTableDataWithQuery();
	}
}
