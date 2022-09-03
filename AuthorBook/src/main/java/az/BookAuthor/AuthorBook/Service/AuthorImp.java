package az.BookAuthor.AuthorBook.Service;

import az.BookAuthor.AuthorBook.Dto.AuthorsDto;
import az.BookAuthor.AuthorBook.DtoToEntityMapper.AuthorDtoMapper;
import az.BookAuthor.AuthorBook.Entities.AuthorEntity;
import az.BookAuthor.AuthorBook.mapper.AuthorMap;
import az.BookAuthor.AuthorBook.ExceptionHandling.NotFoundIdException;
import az.BookAuthor.AuthorBook.Repository.AuthorRepositroy;
import az.BookAuthor.AuthorBook.Repository.BookRepositroy;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@EqualsAndHashCode
public class AuthorImp implements AuthorService {
    private final AuthorRepositroy authorRepositroy;
    private final BookRepositroy bookRepositroy;
    private final AuthorDtoMapper authorDtoMapper;



    @Override
    public List<AuthorsDto> getAuthors() {
        log.info("Start");
        List<AuthorsDto> collect = authorRepositroy
                .findAll()
                .stream().map(AuthorMap.INSTANCE::map)
                .collect(Collectors.toList());
        log.info("End");
        return collect;
    }

    @Override
    public AuthorsDto create(AuthorsDto authorsDto) {

        AuthorEntity save = authorRepositroy.save(authorDtoMapper.getEntity(authorsDto));
        return AuthorMap.INSTANCE.map(save);
    }

    @Override
    public AuthorEntity edit(Long id, AuthorsDto authorsDto) {

        AuthorEntity authorEntity = authorRepositroy.findById(id).orElseThrow(() -> {
            log.error("edit.error author not found");
            throw new NotFoundIdException("ID_NOT_FOUND");
        });

        AuthorEntity authorEntity1 = AuthorMap.INSTANCE.map(authorsDto);


        return authorRepositroy.save(authorEntity1);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Method Starter");
        AuthorEntity authorEntity = authorRepositroy.findById(id).orElseThrow(() -> {
            throw new NotFoundIdException(("ID_NOT-FOUND"));
        });
        authorRepositroy.delete(authorEntity);
        return true;
    }

    public void scheduledTask() {
        List<AuthorEntity> authorEntities = authorRepositroy.findAll();
        authorEntities.forEach(authorEntity -> {
            authorEntity.setDate(LocalDate.now());
            authorRepositroy.save(authorEntity);
        });
    }


    public int sum(int a, int b) {

        return a + b;
    }
}
