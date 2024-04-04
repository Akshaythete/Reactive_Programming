package com.reactive.services;

import com.reactive.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
	
	
	//create book
	public Mono<Book> create(Book book);
	
	//get all book
	public Flux<Book> getAllBook();
	
	//get single book
	public Mono<Book> get(int id);
	
	//update book by id
	public Mono<Book> update(Book book,int id);
	
	//delete book by id
	public Mono<Void> delete(int id);
	
	//search book
	public Flux<Book> search(String query);
	
	

}
