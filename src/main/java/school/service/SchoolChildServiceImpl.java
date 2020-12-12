package school.service;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import school.model.dto.schoolChild.SchoolChildDto;
import school.model.dto.schoolChild.SchoolChildDtoSave;
import school.model.entity.SchoolChild;
import school.model.mapper.SchoolChildMapper;
import school.repo.SchoolChildRepo;
import school.repo.SchoolRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SchoolChildServiceImpl implements SchoolChildService {

    SchoolChildRepo repo;

    SchoolRepo repoSchool;

    SchoolChildMapper mapper;

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<SchoolChildDto> getAll() {
        return Lists.newArrayList(repo.findAll()).stream()
                    .map(schoolchild -> mapper.schoolChildToSchoolChildDto(schoolchild))
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public SchoolChildDto getById(Long id) {
        return mapper.schoolChildToSchoolChildDto(repo.findById(id).get());
    }

    @Override
    public void add(SchoolChildDtoSave schoolChildDtoSave) {
        SchoolChild schoolChild = mapper.schoolChildDtoToSchoolChild(schoolChildDtoSave);
        schoolChild.setSchool(repoSchool.getSchoolByNumber(
                schoolChild.getSchool().getNumber()).get());
        repo.save(schoolChild);
    }

    @Override
    public void edit(Long id, SchoolChildDtoSave schoolChildDtoSave) {
        SchoolChild schoolChild = mapper.schoolChildDtoToSchoolChild(schoolChildDtoSave);
        schoolChild.setId(id);
        schoolChild.setSchool(repoSchool.getSchoolByNumber(
                schoolChild.getSchool().getNumber()).get());
        repo.save(schoolChild);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}