package com.pot.app.pbscatalogservice.in.memory.domain;

import com.pot.app.pbscatalogservice.domain.BookDto;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepositoryInMemoryImpl implements BookRepositoryInMemory {

    private static final Map<String, BookDto> books = new ConcurrentHashMap<>();

    @Override
    public Iterable<BookDto> findAll() {
        return books.values();
    }

    @Override
    public Optional<BookDto> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) :
                Optional.empty();
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public BookDto save(BookDto bookDto) {
        books.put(bookDto.isbn(), bookDto);
        return bookDto;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }

}
