package com.lambert.book.service;

import com.lambert.book.service.dto.BookDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
	Mono<BookDTO> findById(Long id);
	Flux<BookDTO> findAll();
	Mono<BookDTO> create(BookDTO bookDTO);
	Mono<BookDTO> update(BookDTO bookDTO) throws Exception;
	Mono<BookDTO> updatePatch(BookDTO bookDTO) throws Exception;
	Mono<Void> delete(Long id) throws Exception;
}
