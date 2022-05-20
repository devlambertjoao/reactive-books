package com.lambert.book.service.impl;

import java.util.Optional;

import com.lambert.book.entity.BookEntity;
import com.lambert.book.mapper.BookMapper;
import com.lambert.book.repository.BookRepository;
import com.lambert.book.service.BookService;
import com.lambert.book.service.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookMapper bookMapper;

	@Override
	public Mono<BookDTO> findById(Long id) {
		return bookRepository.findById(id).map(bookMapper::toDTO);
	}

	@Override
	public Flux<BookDTO> findAll() {
		return bookRepository.findAll().map(bookMapper::toDTO);
	}

	@Override
	public Mono<BookDTO> create(BookDTO bookDTO) {
		Mono<BookEntity> entity = bookRepository.save(bookMapper.toEntity(bookDTO));

		return Mono.just(bookMapper.toDTO(entity.block()));
	}

	@Override
	public Mono<BookDTO> update(BookDTO bookDTO) throws Exception {
		Optional<BookEntity> entity = bookRepository.findById(bookDTO.getId()).blockOptional();

		if(entity.isEmpty()) {
			throw new Exception("Book not found");
		}

		return bookRepository.save(bookMapper.toEntity(bookDTO)).map(bookMapper::toDTO);
	}

	@Override
	public Mono<BookDTO> updatePatch(BookDTO bookDTO) throws Exception {
		Optional<BookEntity> entity = bookRepository.findById(bookDTO.getId()).blockOptional();

		if(entity.isEmpty()) {
			throw new Exception("Book not found");
		}

		if(bookDTO.getTitle() != null && entity.get().getTitle() != bookDTO.getTitle()) {
			entity.get().setTitle(bookDTO.getTitle());
		}
		
		if(bookDTO.getAuthorName() != null && entity.get().getAuthorName() != bookDTO.getAuthorName()) {
			entity.get().setAuthorName(bookDTO.getAuthorName());
		}


		return bookRepository.save(entity.get()).map(bookMapper::toDTO);
	}

	@Override
	public Mono<Void> delete(Long id) throws Exception {
		Optional<BookEntity> entity = bookRepository.findById(id).blockOptional();

		if(entity.isEmpty()) {
			throw new Exception("Book not found");
		}

		return bookRepository.deleteById(id);
	}

}
