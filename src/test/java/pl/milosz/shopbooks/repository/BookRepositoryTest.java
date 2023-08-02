package pl.milosz.shopbooks.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.milosz.shopbooks.model.Book;

import java.util.List;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void BookRepository_SaveAll_ReturnSavedBooks() {
        //given
        Book book = Book.builder().name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();

        //when
        Book savedBook = bookRepository.save(book);

        //then
        Assertions.assertThat(savedBook).isNotNull();
        Assertions.assertThat(savedBook.getId()).isGreaterThan(0);
    }

    @Test
    public void BookRepository_FindAll_ReturnAllBooks() {
        //given
        Book book = Book.builder().name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();
        Book book1 = Book.builder().name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();
        Book book2 = Book.builder().name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();
        bookRepository.save(book);
        bookRepository.save(book1);
        bookRepository.save(book2);

        //when
        List<Book> allBooks = bookRepository.findAll();

        //then
        Assertions.assertThat(allBooks).isNotNull();
        Assertions.assertThat(allBooks.size()).isEqualTo(3);
    }

}
