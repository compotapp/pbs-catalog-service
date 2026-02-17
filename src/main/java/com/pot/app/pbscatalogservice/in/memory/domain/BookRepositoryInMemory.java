package com.pot.app.pbscatalogservice.in.memory.domain;

import com.pot.app.pbscatalogservice.domain.BookDto;

import java.util.Optional;

public interface BookRepositoryInMemory {
    Iterable<BookDto> findAll();
    Optional<BookDto> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    BookDto save(BookDto bookDto);
    void deleteByIsbn(String isbn);
}
