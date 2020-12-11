package school.repo;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import school.model.entity.School;
import school.model.entity.SchoolChild;

import java.util.Arrays;

//@RunWith(SpringRuner.class)
@DataJpaTest
@FieldDefaults(level = AccessLevel.PRIVATE)
@DisplayName("Тест SchoolChildRepo")
public class SchoolChildRepoTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    SchoolChildRepo repo;

    @Test
    @DisplayName("простой тест добавления")
    public void test_add_simple() {
        Long id = 5L;
        String surname = "surname";
        String name = "name";
        School school = new School();
        SchoolChild entyty = new SchoolChild(id, surname, name, school);
        SchoolChild entytyPersisten = entityManager.persist(entyty);
        entityManager.flush();
        Assertions.assertTrue(repo.findById(entytyPersisten.getId()).isPresent());
        Assertions.assertEquals(repo.findById(entytyPersisten.getId()).get().getName(), name);
    }

    // записать несколько раз и проверить
}