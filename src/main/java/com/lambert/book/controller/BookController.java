package com.lambert.book.controller;

import com.lambert.book.service.dto.BookDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "book")
public class BookController {
	
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<BookDTO> findById(@PathVariable Long id) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(id);
		bookDTO.setTitle("My book");
		bookDTO.setAuthorName("Author Name");

		return Mono.just(bookDTO);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<BookDTO> findAll() {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(1l);
		bookDTO.setTitle("My book");
		bookDTO.setAuthorName("Author Name"); BookDTO bookDTO2 = new BookDTO();
		bookDTO2.setId(2l);
		bookDTO2.setTitle("My book 2");
		bookDTO2.setAuthorName("Author Name");

		BookDTO[] bookList = { bookDTO, bookDTO2 };

		return Flux.fromArray(bookList);
	}

	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<BookDTO> create(@RequestBody BookDTO bookDTO) {
		return Mono.just(bookDTO);
	}
	
	@PutMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Mono<BookDTO> update(@RequestBody BookDTO bookDTO) {
		return Mono.just(bookDTO);
	}
	
	@PatchMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Mono<BookDTO> updatePatch(@RequestBody BookDTO bookDTO) {
		return Mono.just(bookDTO);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable Long id) {
		return Mono.empty();
	}
}
