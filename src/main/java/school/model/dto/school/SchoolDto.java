package school.model.dto.school;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Объект учебных заведений")
public class SchoolDto {
    @Schema(description = "Номер учебного заведения")
    String number;
    @Schema(description = "Школьники")
    List<SchoolChildDto> schoolChild;
}