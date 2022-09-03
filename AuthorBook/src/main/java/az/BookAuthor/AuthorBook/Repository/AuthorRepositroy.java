package az.BookAuthor.AuthorBook.Repository;

import az.BookAuthor.AuthorBook.Entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepositroy extends JpaRepository<AuthorEntity, Long> {
}
