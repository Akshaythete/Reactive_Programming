package com.reactive.services.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.entity.Book;
import com.reactive.repository.BookRepo;
import com.reactive.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo bookRepo;

	@Override
	public Mono<Book> create(Book book) {
		Mono<Book> createdBook = bookRepo.save(book);
		return createdBook;
	}

	@Override
	public Flux<Book> getAllBook() {
		Flux<Book> findAll = bookRepo.findAll().delayElements(Duration.ofSeconds(3)).log();
		return findAll;
	}

	@Override
	public Mono<Book> get(int id) {
		Mono<Book> item = bookRepo.findById( id);
		return item;
	}

	@Override
	public Mono<Book> update(Book book, int id) {
		Mono<Book> oldBook = bookRepo.findById(id);
		 return oldBook.flatMap(book1->{
			book1.setName(book.getName());
			book1.setDescription(book.getDescription());
			book1.setAuthor(book.getAuthor());
			book1.setPublisher(book.getPublisher());
			return bookRepo.save(book1);
			});
		
	}

	@Override
	public Mono<Void> delete(int id) {
		 
				return bookRepo.findById(id)
				.flatMap(book->bookRepo.delete(book));
			
		
		
	}

	@Override
	public Flux<Book> search(String query) {
		 return bookRepo.searchNameOfBook("%"+query+"%");

	}

}
