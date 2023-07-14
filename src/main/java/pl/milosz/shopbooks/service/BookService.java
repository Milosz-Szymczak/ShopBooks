package pl.milosz.shopbooks.service;

import pl.milosz.shopbooks.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book findByID(long id);

    Book updateBook(Book book, long id);

    void deleteBook(long id);

}
