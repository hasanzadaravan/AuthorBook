package az.BookAuthor.AuthorBook.mapper;

import az.BookAuthor.AuthorBook.Dto.AuthorsDto;
import az.BookAuthor.AuthorBook.Dto.BookDto;
import az.BookAuthor.AuthorBook.Entities.AuthorEntity;
import az.BookAuthor.AuthorBook.Entities.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class AuthorMap {  //mapper

    public static final AuthorMap INSTANCE = Mappers.getMapper(AuthorMap.class);


    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "bookEntities", qualifiedByName = "bookmap", target = "bookDtos")
    })
    public abstract AuthorsDto map(AuthorEntity authorEntity);

    @Mappings({
            @Mapping(source = "name",  target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "bookDtos", target = "bookEntities")
    })
    public abstract AuthorEntity map(AuthorsDto authorsDto);

    @Named("bookmap")
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "topic", target = "topic")
    })

    public abstract BookDto map(BookEntity bookEntity);


}
