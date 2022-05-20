package com.lambert.book.controller;

import com.lambert.book.service.BookService;
import com.lambert.book.service.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private BookService bookService;

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<BookDTO> findById(@PathVariable Long id) {
		return bookService.findById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<BookDTO> findAll() {
		return bookService.findAll();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<BookDTO> create(@RequestBody BookDTO bookDTO) {
		return bookService.create(bookDTO);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<BookDTO> update(@RequestBody BookDTO bookDTO) {
		try {
			return bookService.update(bookDTO);
		} catch (Exception e) {
			return Mono.error(e);
		}
	}

	@PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<BookDTO> updatePatch(@RequestBody BookDTO bookDTO) {
		try {
			return bookService.updatePatch(bookDTO);
		} catch (Exception e) {
			return Mono.error(e);
		}
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable Long id) {
		try {
			return bookService.delete(id);
		} catch (Exception e) {
			return Mono.error(e);
		}
	}
}
