package school.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Schema(description = "Объект учебных заведений")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    @Schema(description = "Номер учебного заведения")
    String number;

    @OneToMany(mappedBy = "school")
    @Schema(description = "Школьники")
    List<SchoolChild> schoolChild;
}