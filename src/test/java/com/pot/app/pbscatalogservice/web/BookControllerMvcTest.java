//package com.pot.app.pbscatalogservice.web;
//
//import com.polarbookshop.catalogservice.domain.BookNotFoundException;
//import com.polarbookshop.catalogservice.domain.BookService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(BookController.class)
//class BookControllerMvcTest {
//
//    @Autowired
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    private MockMvc mockMvc;
//
//    @Mock
//    private BookService bookService;
//
//    @Test
//    void whenGetBookNotExistingThenShouldReturn404() throws Exception {
//        String isbn = "73737313940";
//        given(bookService.viewBookDetails(isbn))
//                .willThrow(BookNotFoundException.class);
//        mockMvc
//                .perform(get("/books/" + isbn))
//                .andExpect(status().isNotFound());
//    }
//}