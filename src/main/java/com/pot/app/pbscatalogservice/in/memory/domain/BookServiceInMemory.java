package com.pot.app.pbscatalogservice.in.memory.domain;

import com.pot.app.pbscatalogservice.domain.BookDto;
import com.pot.app.pbscatalogservice.domain.BookAlreadyExistsException;
import com.pot.app.pbscatalogservice.domain.BookNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceInMemory {
    private final BookRepositoryInMemory repository;

    public BookServiceInMemory(BookRepositoryInMemory repository) {
        this.repository = repository;
    }

    public Iterable<BookDto> viewBookList() {
        return repository.findAll();
    }

    public BookDto viewBookDetails(String isbn) {
        return repository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public BookDto addBookToCatalog(BookDto bookDto) {
        if (repository.existsByIsbn(bookDto.isbn())) {
            throw new BookAlreadyExistsException(bookDto.isbn());
        }
        return repository.save(bookDto);
    }

    public void removeBookFromCatalog(String isbn) {
        repository.deleteByIsbn(isbn);
    }

    public BookDto editBookDetails(String isbn, BookDto bookDto) {
        return repository.findByIsbn(isbn)
                .map(existingBook -> {
                    var bookToUpdate = new BookDto(
                            existingBook.isbn(),
                            bookDto.title(),
                            bookDto.author(),
                            bookDto.price());
                    return repository.save(bookToUpdate);
                })
                .orElseGet(() -> addBookToCatalog(bookDto));
    }
}
