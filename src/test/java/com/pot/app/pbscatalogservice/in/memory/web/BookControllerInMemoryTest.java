package com.pot.app.pbscatalogservice.in.memory.web;

import com.pot.app.pbscatalogservice.domain.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookDtoControllerInMemoryTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenPostRequestThenBookDtoCreated() {
        var expectedBookDto = new BookDto("1231231231", "Title", "Author", 9.90);
        webTestClient
                .post()
                .uri("/in-memory/books")
                .bodyValue(expectedBookDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(BookDto.class).value(actualBookDto -> {
                    assertThat(actualBookDto).isNotNull();
                    assertThat(actualBookDto.isbn())
                            .isEqualTo(expectedBookDto.isbn());
                });
    }

}