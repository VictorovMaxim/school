package school.model.dto.schoolChild;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Объект школьников")
public class SchoolChildDtoSave {
    @Schema(description = "Фамилия", example = "Петров")
    String surname;
    @Schema(description = "Имя", example = "Иван")
    String name;
    @Schema(description = "Учебное заведение")
    SchoolDto school;
}