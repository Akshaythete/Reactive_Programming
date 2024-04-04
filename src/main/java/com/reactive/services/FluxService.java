package com.reactive.services;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FluxService {
	
	
	//how to creating flux
	public Flux<String> flux()
	{
		return Flux.just("akshay","kisan","Thete").log();
		
	}
	//list of flux
	public Flux<Integer> numbers()
	{
		List<Integer> num=List.of(1,3,4,5,78,8,8);
		return Flux.fromIterable(num).log();
	}
	
	//empty flux
	public Flux<Void> getEmptyFlux()
	{
		return Flux.empty();
	}
	
	//map operator
	
	public Flux<String> getMap()
	{
		Flux<String> mapFlux = flux().map(data-> data.toUpperCase()).log();
		return mapFlux;
	}
	
	//filter operator
	
	public Flux<String> getFilter()
	{
		Flux<String> filter = flux().filter(data-> data.length()>4).log();
		return filter;
	}
	
	//flatMap and delayElement
	
	public Flux<String> flatMap()
	{
		Flux<String> flatMap = flux().flatMap(data->Flux.just(data.split(""))).delayElements(Duration.ofSeconds(2)).log();
		return flatMap;
	}
	
	//transform
	
	public Flux<String> transform()
	{
		Function<Flux<String>, Flux<String>> funInterface=(name)-> name.map(String::toUpperCase);
		return flux().transform(funInterface).log();
	}
	
	//if
	public Flux<String> ifexample( int length)
	{
		 return flux().filter(name-> name.length()>length).log();
		
		
	}

}
