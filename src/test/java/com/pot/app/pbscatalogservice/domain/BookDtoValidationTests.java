package com.pot.app.pbscatalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BookDtoValidationTests {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var BookDto =
                new BookDto("1234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<BookDto>> violations = validator.validate(BookDto);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFails() {
        var BookDto =
                new BookDto("a234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<BookDto>> violations = validator.validate(BookDto);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The ISBN format must be valid.");
    }
}
