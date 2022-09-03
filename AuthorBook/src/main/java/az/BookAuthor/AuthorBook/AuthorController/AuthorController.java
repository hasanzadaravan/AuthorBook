package az.BookAuthor.AuthorBook.AuthorController;//controller

import az.BookAuthor.AuthorBook.Dto.AuthorsDto;
import az.BookAuthor.AuthorBook.Entities.AuthorEntity;
import az.BookAuthor.AuthorBook.Service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/authors")
@AllArgsConstructor
@Api(value = "My BookAuthor Controller documantation")
public class AuthorController {
    private final AuthorService authorimpl;



    @GetMapping
    @ApiOperation(value = "This method used for return All Authors")
    public ResponseEntity<List<AuthorsDto>> getAuthors() {

        return ResponseEntity.ok(authorimpl.getAuthors());
    }
    @PutMapping
    public ResponseEntity<AuthorsDto> insert(@RequestBody @ApiParam(value = "authorentity body for postmapping  ")
                                             @Valid
                                             AuthorsDto authorsDto) {

        return ResponseEntity.ok(authorimpl.create(authorsDto));
    }

    @PostMapping("/{id}")
    public ResponseEntity<AuthorEntity> edit(@PathVariable Long id, @RequestBody AuthorsDto authorsDto) {
        AuthorEntity edit = authorimpl.edit(id,authorsDto);
        return ResponseEntity.ok(edit);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        Boolean delete = authorimpl.delete(id);
        return ResponseEntity.ok(delete);
    }

}
