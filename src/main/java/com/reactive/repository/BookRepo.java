package com.reactive.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepo extends ReactiveCrudRepository<Book, Integer> {
	
	
	//finder method
	public Mono<Book> findByName(String name);
	
	public Flux<Book> findByAuthor(String author);
	
	public Flux<Book> findByPublisher(String publisher);
	
	public Flux<Book> findByNameAndAuthor(String name,String author);

	
	//query method
	
	@Query("select * from book  where name= :name")
	public Flux<Book> getAllName(String name);
	
	
	@Query("select * from book where name LIKE :name")
	public Flux<Book> searchNameOfBook(String name);
	
}