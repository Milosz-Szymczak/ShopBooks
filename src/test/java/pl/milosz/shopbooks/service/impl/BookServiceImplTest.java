package pl.milosz.shopbooks.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.milosz.shopbooks.model.Book;
import pl.milosz.shopbooks.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    @Test
    void BookService_saveBook_returnBook() {
        Book book = Book.builder().name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();

        when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);
        Book book1 = bookServiceImpl.saveBook(book);

        Assertions.assertThat(book1).isNotNull();
        verify(bookRepository).save(book);
    }

    @Test
    void getAllBooks() {
    }

    @Test
    void findByID() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBook() {
    }
}