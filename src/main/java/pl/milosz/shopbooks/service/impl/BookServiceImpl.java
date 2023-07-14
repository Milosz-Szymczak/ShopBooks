package pl.milosz.shopbooks.service.impl;

import org.springframework.stereotype.Service;
import pl.milosz.shopbooks.model.Book;
import pl.milosz.shopbooks.repository.BookRepository;
import pl.milosz.shopbooks.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
