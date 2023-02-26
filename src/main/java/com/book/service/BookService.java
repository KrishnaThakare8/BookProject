package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.dao.BookRepository;
import com.book.entity.Book;

@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	// Get all books
	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	// Get single book
	public Book getBook(int id) {
		return bookRepository.findById(id);
	}

	// Add book
	public Book addBook(Book book) {
		Book save = bookRepository.save(book);
		return save;
	}

	// Delete single book
	public void deleteBookById(int id) {
		bookRepository.deleteById(id);
	}

	// Update book
	public void updateBook(Book book, int id) {
		
		book.setId(id);
		bookRepository.save(book);
	}
}

//public static List<Book> list = new ArrayList<>();
//static {
//	list.add(new Book(1, "Ramayan", "Walmiki"));
//	list.add(new Book(2, "Mahabharat", "Walmiki"));
//	list.add(new Book(3, "Secrete", "Ronhda Brean"));
//}
//// Get all books
//public List<Book> getBooks() {
//	return list;
//}
//
//// Get single book
//public Book getBook(int id) {
//	return list.stream().filter(book -> book.getId() == id).findFirst().get();
//}
//
//// Add book
//public Book addBook(Book book) {
//	list.add(book);
//	return book;
//}
//
//// Delete single book
//public void deleteBookById(int id) {
//	list = list.stream().filter(book1 -> book1.getId() != id).collect(Collectors.toList());
//}
//
//// Update book
//public void updateBook(Book book, int id) {
//	list = list.stream().map(b -> {
//		if (b.getId() == id) {
//			b.setAuthor(book.getAuthor());
//			b.setTitle(book.getTitle());
//		}
//		return b;
//	}).collect(Collectors.toList());
//}