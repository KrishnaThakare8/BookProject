package com.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.service.BookService;

@SpringBootApplication
public class BootBookProjectCrudApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootBookProjectCrudApplication.class, args);
		
		BookService bookService = new BookService();
		
	}

}
