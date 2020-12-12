package school.model.dto.schoolChild;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Объект школьников")
public class SchoolChildDto {
    @Schema(example = "1")
    Long id;
    @Schema(description = "Фамилия", example = "Петров")
    String surname;
    @Schema(description = "Имя", example = "Иван")
    String name;
    @Schema(description = "Учебное заведение")
    SchoolDto school;
}