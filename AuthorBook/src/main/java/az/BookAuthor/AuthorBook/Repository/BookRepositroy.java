package az.BookAuthor.AuthorBook.Repository;

import az.BookAuthor.AuthorBook.Entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositroy extends JpaRepository<BookEntity,Long> {
}
