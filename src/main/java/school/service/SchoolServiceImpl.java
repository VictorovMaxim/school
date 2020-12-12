package school.service;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import school.model.dto.school.SchoolDto;
import school.model.dto.school.SchoolDtoAdd;
import school.model.entity.School;
import school.model.mapper.SchoolMapper;
import school.repo.SchoolRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    SchoolRepo repo;

    SchoolMapper mapper;

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<SchoolDto> getAll() {
        return Lists.newArrayList(repo.findAll()).stream()
                    .map(school -> mapper.schoolToSchoolDto(school))
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public SchoolDto getSchoolByNumber(String number) {
        return mapper.schoolToSchoolDto(repo.getSchoolByNumber(number).get());
    }

    @Override
    public void add(SchoolDtoAdd schoolDtoAdd) {
        repo.save(mapper.schoolDtoToSchool(schoolDtoAdd));
    }

    @Override
    public void edit(String number, SchoolDtoAdd schoolDtoAdd) {
        Optional<School> schoolOptional = repo.getSchoolByNumber(number);
        if (schoolOptional.isPresent()) {
            School school = schoolOptional.get();
            school.setNumber(schoolDtoAdd.getNumber());
            repo.save(school);
        }
    }

    @Override
    public void delete(String number) throws RuntimeException {
        Optional<School> schoolOptional = repo.getSchoolByNumber(number);
        if (schoolOptional.isPresent()) {
            if (schoolOptional.get().getSchoolChild().size() > 0) {
                throw new RuntimeException(
                        "Сначала удалите у " + number + " всех школьников");
            }
            repo.deleteByNumber(number);
        }
    }
}