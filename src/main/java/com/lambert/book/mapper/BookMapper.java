package com.lambert.book.mapper;

import com.lambert.book.entity.BookEntity;
import com.lambert.book.service.dto.BookDTO;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public BookDTO toDTO(BookEntity entity) {
		BookDTO dto = new BookDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setAuthorName(entity.getAuthorName());

		return dto;
	}

	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setAuthorName(dto.getAuthorName());

		return entity;
	}
}
