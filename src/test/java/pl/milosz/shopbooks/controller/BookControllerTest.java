package pl.milosz.shopbooks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.milosz.shopbooks.model.Book;
import pl.milosz.shopbooks.service.BookService;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void SaveBook_CheckStatusAndJSONPatch_returnCreated() throws Exception {
        Book book = Book.builder().id(1L).name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();

        when(bookService.saveBook(book)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(book)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Clean Code"));
    }

    @Test
    void GetAllBooks_CheckStatusAndJSONPatch_returnOK() throws Exception {
        Book book = Book.builder().id(1L).name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();

        Book book2 = Book.builder().id(2L).name("a").author("a")
                .kind("a").releaseDate("2001-03-01").isbn(32884L).build();

        List<Book> allBooks = List.of(book,book2);

        when(bookService.getAllBooks()).thenReturn(allBooks);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(allBooks)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Clean Code"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value("a"));
    }

    @Test
    void GetBookById_CheckStatusAndJSONPatch_returnStatusIsOk() throws Exception {
        Book book = Book.builder().id(1L).name("Clean Code").author("Martin Robert C.")
                .kind("Computer Science").releaseDate("2009-03-01").isbn(9780132350884L).build();

        when(bookService.findByID(1L)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(book)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Clean Code"));
    }

    @Test
    void UpdateBookById_CheckStatusAndJSONPatch_returnCreated() {
    }

    @Test
    void DeleteBookById_CheckStatusAndJSONPatch_returnCreated() {
    }
}