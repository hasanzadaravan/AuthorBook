package az.BookAuthor.AuthorBook.DtoToEntityMapper;

import az.BookAuthor.AuthorBook.Dto.AuthorsDto;
import az.BookAuthor.AuthorBook.Dto.BookDto;
import az.BookAuthor.AuthorBook.Entities.AuthorEntity;
import az.BookAuthor.AuthorBook.Entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorDtoMapper {

    public AuthorEntity getEntity(AuthorsDto authorsDto) {
        return AuthorEntity
                .builder().
                name(authorsDto
                        .getName())
                .surname(authorsDto
                        .getSurname())
                .bookEntities(authorsDto
                        .getBookDtos()
                        .stream().
                         map(this::getBookEntity)
                        .collect(Collectors
                                .toList()))
                .date(authorsDto
                        .getDate())
                .build();
    }

    public BookEntity getBookEntity(BookDto bookDto) {
        return BookEntity.builder()
                .name(bookDto.getName())
                .topic(bookDto.getTopic())
                .build();
    }


}
