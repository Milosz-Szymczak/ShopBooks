package pl.milosz.shopbooks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_name", nullable = false )
    private String name;

    @Column(name = "author", nullable = false )
    private String author;

    @Column(name = "kind_of_book", nullable = false )
    private String kind;

    @Column(name = "release_date", nullable = false, length = 10)
    private String releaseDate;

    @Column(name = "isbn", nullable = false )
    private long isbn;

}
