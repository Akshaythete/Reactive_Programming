package com.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.entity.Book;
import com.reactive.repository.BookRepo;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class BookRepoTest {
	
	@Autowired
	private BookRepo bookRepo;
	@Test
	public void findByName()
	{
		Mono<Book> findByName = bookRepo.findByName("core java");
		StepVerifier.create(findByName)
		            .expectNextCount(1)
		            .verifyComplete();
		System.out.println("================================");
	}
	@Test
	public void findByPublisher()
	{
		
		bookRepo.findByPublisher("okh team").as(StepVerifier::create).expectNextCount(2).verifyComplete();
	}
	@Test
	public void findByNameAndAuthor()
	{
		bookRepo.findByNameAndAuthor("Core python", "Abc").as(StepVerifier::create).expectNextCount(2).verifyComplete();
	}
	
	@Test
	public void getAllName()
	{
		bookRepo.getAllName("Core Java").as(StepVerifier::create).expectNextCount(1).verifyComplete();
	}
	
	@Test
	public void searchNameOfBook()
	{
		bookRepo.searchNameOfBook("%re%").as(StepVerifier::create).expectNextCount(3).verifyComplete();
	}
}
