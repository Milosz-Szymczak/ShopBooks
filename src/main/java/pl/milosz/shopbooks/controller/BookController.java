package pl.milosz.shopbooks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.milosz.shopbooks.model.Book;
import pl.milosz.shopbooks.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
        return new ResponseEntity<>(bookService.findByID(id), HttpStatus.OK);
    }

    @PutMapping({"{id}"})
    public ResponseEntity<Book> updateBookById(@PathVariable("id") long id, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(book, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Success delete book by id", HttpStatus.OK);
    }
}
