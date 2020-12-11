package school.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class SchoolChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String surname;

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    School school;
}