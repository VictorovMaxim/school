package school.model.dto.school;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Объект школьников")
public class SchoolChildDto {
    @Schema(description = "Фамилия")
    String surname;
    @Schema(description = "Имя")
    String name;
}