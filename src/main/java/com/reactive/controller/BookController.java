package com.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.entity.Book;
import com.reactive.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/create")
	public Mono<Book> create(@RequestBody Book book)
	{
		Mono<Book> create = bookService.create(book);
		return create;
		
	}
	
	@GetMapping("/getbook/{id}")
	public Mono<Book> getBook( @PathVariable int id)
	{  Mono<Book> book = bookService.get(id);
		return book;
		
	}
	
	@GetMapping("/allBook")
	public Flux<Book> getAll()
	{
		 return bookService.getAllBook();
	}
	
	@PutMapping("/update/{id}")
	public Mono<Book> update(@RequestBody Book book,@PathVariable int id)
	{
		Mono<Book> update = bookService.update(book, id);
		return update;
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> delete(@PathVariable int id)
	{
		 return bookService.delete(id);
	}
	
	@GetMapping("/search")
	public  Flux<Book> searchBookByName(@RequestParam("query") String query)
	{
		return bookService.search(query);
		
	}

}
