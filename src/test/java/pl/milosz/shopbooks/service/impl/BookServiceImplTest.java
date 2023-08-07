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

import java.util.List;

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
    void BookService_getAllBooks_returnAllBooks() {
        Book book = Book.builder().name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();
        Book book2 = Book.builder().name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();

        List<Book> books = List.of(book, book2);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> allBooks = bookServiceImpl.getAllBooks();

        Assertions.assertThat(allBooks).isNotNull();
        Assertions.assertThat(allBooks.size()).isEqualTo(2);
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