//package school.repo;
//
//import org.springframework.data.repository.CrudRepository;
//import school.model.entity.School;
//
//import java.util.Optional;
//
//public interface SchoolRepo extends CrudRepository<School, Long> {
//
//    Optional<School> getSchoolByNumber(String number);
//
//    void deleteByNumber(String number);
//}