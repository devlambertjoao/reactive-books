package com.lambert.book.repository;

import com.lambert.book.entity.BookEntity;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
