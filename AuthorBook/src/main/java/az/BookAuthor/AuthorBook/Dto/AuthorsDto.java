package az.BookAuthor.AuthorBook.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Builder
@ApiModel(value = "My Authors Mode")
@AllArgsConstructor
@Getter
@Setter


public class AuthorsDto {
    @ApiModelProperty
    @NotBlank(message = "bos olmaz")
    private String name;
    @ApiModelProperty
    @NotBlank(message = "bos olmaz")
    private String surname;
    @ApiModelProperty
    private LocalDate date;
    @ApiModelProperty
    private List<BookDto> bookDtos=new ArrayList<>();

    public AuthorsDto() {
    }
}