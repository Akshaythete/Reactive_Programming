package com.reactive;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveProgrammingApplicationTests {

	@Test
	void contextLoads() {
	}
	
	//mono- publisher have  0 or 1 item/element
	//created mono
    @Test
	void mono()
	{
		System.out.println("testing with mono");
		
//		Mono<String> m1 = Mono.just("Akshay is start learning with reactive")
//				.log();
		
		//consume mono with subscriber
//		m1.subscribe(data->{
//			System.out.println("data is :"+data);
//		});
		
		//or method refrence
//		m1.subscribe(System.out::println);
		
		// 1) method zip() and zipWith()
		
		Mono<String> m1= Mono.just("welcome!!!");
		Mono<String> m2 = Mono.just("thank u..");
		Mono<Integer> m3 = Mono.just(123);
		
//		Mono<Tuple3<String, String, Integer>> combinedMono = Mono.zip(m1, m2,m3);
//		combinedMono.subscribe(data->
//		{
//			System.out.println(data);
//		});
//		
//		
//		// 2) zipWith  mono method
//		Mono<Tuple2<String, String>> zipWith = m1.zipWith(m2);
//		zipWith.subscribe(data->
//		{
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//		});
		
		
		// 3) map()
		
//		Mono<String> map = m1.map(data->data.toUpperCase());
//		map.subscribe(d->{
//			System.out.println(d);
//		});
		
		// 4) flatMap()
		
//		Mono<String[]> flatMap = m2.flatMap(item->Mono.just(item.split(" ")));
//		
//		flatMap.subscribe(d->{
//			
//			for(String s:d)
//			{
//				System.out.println(s);
//			}
//			System.out.println(d);
//		});
//		
//		System.out.println("=============================================");
//		
//		// 5) flatMapMany
//		
//		
//		Flux<String> flatMapMany = m2.flatMapMany(item-> Flux.just(item.split(" ")));
//		
//		flatMapMany.subscribe(data->{
//			System.out.println(data);
//		});
		
		//6) concateWith()
		
		Flux<String> concatWith = m1.concatWith(m2).log();
		concatWith.subscribe(System.out::println);
	}
}
