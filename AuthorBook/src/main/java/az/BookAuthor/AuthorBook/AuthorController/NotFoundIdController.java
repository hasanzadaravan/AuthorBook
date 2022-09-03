package az.BookAuthor.AuthorBook.AuthorController;

import az.BookAuthor.AuthorBook.ExceptionHandling.NotFoundIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundIdController {

    @ExceptionHandler(value = NotFoundIdException.class)
       //@ResponseStatus
     public ResponseEntity<Object> exception(NotFoundIdException exception) {  //ExceptionResponse
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }
}
