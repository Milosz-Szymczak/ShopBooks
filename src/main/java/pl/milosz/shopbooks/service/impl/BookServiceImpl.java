package pl.milosz.shopbooks.service.impl;

import org.springframework.stereotype.Service;
import pl.milosz.shopbooks.exception.ResourceNotFoundException;
import pl.milosz.shopbooks.model.Book;
import pl.milosz.shopbooks.repository.BookRepository;
import pl.milosz.shopbooks.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


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

    public Book findByID(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
    }

    @Override
    public Book updateBook(Book book, long id) {
        Book existingBook = findByID(id);

        existingBook.setName(book.getName());
        existingBook.setKind(book.getKind());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setReleaseDate(book.getReleaseDate());
        existingBook.setIsbn(book.getIsbn());

        bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public void deleteBook(long id) {
        Book existingBook = findByID(id);
        bookRepository.deleteById(existingBook.getId());
    }
}
