package com.pot.app.pbscatalogservice.controller;

import com.pot.app.pbscatalogservice.domain.BookDto;
import com.pot.app.pbscatalogservice.in.memory.domain.BookServiceInMemory;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/books")
public class BookController {
    private final BookServiceInMemory service;

    public BookController(BookServiceInMemory service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<BookDto> get() {
        return service.viewBookList();
    }

    @GetMapping("{isbn}")
    public BookDto getByIsbn(@PathVariable String isbn) {
        return service.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto post(@Valid @RequestBody BookDto bookDto) {
        return service.addBookToCatalog(bookDto);
    }

    @PutMapping("{isbn}")
    public BookDto put(@PathVariable String isbn, @Valid @RequestBody BookDto bookDto) {
        return service.editBookDetails(isbn, bookDto);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        service.removeBookFromCatalog(isbn);
    }
}