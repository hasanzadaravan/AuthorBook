package az.BookAuthor.AuthorBook.Service;

import az.BookAuthor.AuthorBook.Dto.AuthorsDto;
import az.BookAuthor.AuthorBook.Entities.AuthorEntity;

import java.util.List;

public interface AuthorService { //AuthorService
     List<AuthorsDto> getAuthors();
    AuthorsDto create(AuthorsDto authorsDto);
    AuthorEntity edit(Long id,AuthorsDto authorsDto);
    Boolean delete(Long id);

}
