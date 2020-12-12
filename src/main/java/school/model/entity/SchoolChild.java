package school.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Schema(description = "Объект школьников")
public class SchoolChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Schema(description = "Фамилия")
    String surname;

    @Schema(description = "Имя")
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @Schema(description = "Учебное заведение")
    School school;
}