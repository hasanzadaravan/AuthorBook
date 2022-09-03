package az.BookAuthor.AuthorBook.ExceptionHandling;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException(String message) {
        super(message);
    }
}
