package com.lambert.book.mapper;

import com.lambert.book.entity.BookEntity;
import com.lambert.book.service.dto.BookDTO;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public BookDTO toDTO(BookEntity entity) { 
		BookDTO dto = new BookDTO();
		//TODO: Implement this method
		return dto;
	}

	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();

		//TODO: Implement this method
		return entity;
	}
}
