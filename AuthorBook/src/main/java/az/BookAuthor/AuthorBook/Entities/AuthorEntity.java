package az.BookAuthor.AuthorBook.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Bos Qala Bilmez")
    private String name;
    @NotNull(message = "Bos olmaz")
    private String surname;
    @CreationTimestamp
    private LocalDate date;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name = "authors_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    private List<BookEntity> bookEntities;
    public AuthorEntity() {

    }
}
