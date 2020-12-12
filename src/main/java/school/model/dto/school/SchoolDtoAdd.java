package school.model.dto.school;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Объект учебных заведений")
public class SchoolDtoAdd {
    @Schema(description = "Номер учебного заведения", example = "Лицей №2")
    String number;
}