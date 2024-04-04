package com.reactive;

import static org.mockito.Mockito.validateMockitoUsage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.services.FluxService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxTest {
	@Autowired
	private FluxService fluxService;
//	@Test
//	public void test()
//	{
//		fluxService.flux().subscribe(data->{
//			System.out.println(data);
//			System.out.println("flux done");
//		});
//	}
//    
//	
//	@Test
//	public void testOfList()
//	{
//		fluxService.numbers().subscribe(data->{
//			System.out.println(data);
//			System.out.println("Test of List");
//		});
//	}
//	
//	@Test
//	public void testMapFlux()
//	{
//		fluxService.getMap().subscribe(System.out::println);
//	}
//	
//	@Test
//	public void testFilter()
//	{
//		Flux<String> filter = fluxService.getFilter();
//		StepVerifier.create(filter)
//		            .expectNextCount(3)
//		            .verifyComplete();
//	}
//	@Test
//	public void testFlatMap()
//	{
//		Flux<String> flatMap = fluxService.flatMap();
//		StepVerifier.create(flatMap)
//		             .expectNextCount(16)
//		             .verifyComplete();
//	}
//	@Test
//	public void testTransform()
//	{
//		Flux<String> transform = fluxService.transform();
//		StepVerifier.create(transform)
//		             .expectNextCount(3)
//		             .verifyComplete();
//	}
	@Test
	public void testIf()
	{
		Flux<String> ifexample = fluxService.ifexample(4);
		StepVerifier.create(ifexample)
		             .expectNextCount(3)
		             .verifyComplete();
	}
}
