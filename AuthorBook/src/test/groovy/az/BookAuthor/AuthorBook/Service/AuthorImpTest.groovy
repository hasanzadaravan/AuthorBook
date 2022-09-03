package az.BookAuthor.AuthorBook.Service

import az.BookAuthor.AuthorBook.Dto.AuthorsDto
import az.BookAuthor.AuthorBook.Dto.BookDto
import az.BookAuthor.AuthorBook.DtoToEntityMapper.AuthorDtoMapper
import az.BookAuthor.AuthorBook.Entities.AuthorEntity
import az.BookAuthor.AuthorBook.Repository.AuthorRepositroy
import az.BookAuthor.AuthorBook.Repository.BookRepositroy
import az.BookAuthor.AuthorBook.mapper.AuthorMap
import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters


class AuthorImpTest extends spock.lang.Specification {


    private AuthorImp authorImp
    private AuthorRepositroy authorRepositroy;
    private BookRepositroy bookRepositroy;
    private AuthorDtoMapper authorDtoMapper;
    private EasyRandom generator = new EasyRandom();

    void setup() {
        authorRepositroy = Mock()
        bookRepositroy = Mock()
        authorDtoMapper = Mock()


        authorImp = new AuthorImp(authorRepositroy, bookRepositroy, authorDtoMapper)

    }


    def "testSum"() {

        when:
        def result = authorImp.sum(5, 6)

        then:
        result == 11
    }

    def "testgetAuthors"() {









  




    }


}
