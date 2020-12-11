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

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SchoolChildServiceImpl implements SchoolChildService {

    SchoolChildRepo repo;

    SchoolChildMapper mapper;

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<SchoolChildDto> getAll() {
        return Lists.newArrayList(repo.findAll()).stream()
                .map(schoolchild -> mapper.schoolChildToSchoolChildDto(schoolchild))
                .collect(Collectors.toList());
    }

    @Override
    public void add(SchoolChildDtoSave schoolChildDtoSave) {
        System.out.println(schoolChildDtoSave);
        SchoolChild schoolChild = mapper.schoolChildDtoToSchoolChild(schoolChildDtoSave);
        System.out.println(schoolChild);
        repo.save(schoolChild);
    }

    @Override
    public void edit(Long id, SchoolChildDtoSave schoolchildDtoSave) {
        SchoolChild schoolchild = mapper.schoolChildDtoToSchoolChild(schoolchildDtoSave);
        schoolchild.setId(id);
        repo.save(schoolchild);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}