package school.repo;

import org.springframework.data.repository.CrudRepository;
import school.model.entity.SchoolChild;

public interface SchoolChildRepo extends CrudRepository<SchoolChild, Long> {
}