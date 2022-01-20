package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.Book;
import com.example.demo.dao.BookRepository;




@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	BookRepository bookRep;
	
	@GetMapping("hello")
	public ResponseEntity<String> sayHello(@RequestParam("name") String name) {
		String welcomeMessage = "Hello " + name;
		return new ResponseEntity<String>(welcomeMessage, HttpStatus.OK);
	}
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") String bookId) {
		Optional<Book> book = bookRep.findById(bookId);
		if (book.isPresent()) {
			return ResponseEntity.ok(book.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not found");
	}
	
	@PostMapping("books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) throws URISyntaxException {
		Book newbook = bookRep.save(book);
		// return ResponseEntity.ok(newbook);
		return ResponseEntity.created(new URI("http://localhost:8080/books/" + newbook.getId())).body(newbook);
	}
	
	@GetMapping("books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> actualList = new ArrayList<Book>();
		bookRep.findAll().iterator().forEachRemaining(actualList::add);
		return new ResponseEntity<List<Book>>(actualList, HttpStatus.OK);
	}
}
