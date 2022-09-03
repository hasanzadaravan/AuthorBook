package az.BookAuthor.AuthorBook.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Builder
@ApiModel(value = "My Book Model")
@Getter
@Setter
@AllArgsConstructor
public class BookDto {
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String topic;

    public BookDto() {
    }


}
