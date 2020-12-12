package school.service;

import school.model.dto.schoolChild.SchoolChildDto;
import school.model.dto.schoolChild.SchoolChildDtoSave;

import java.util.List;

public interface SchoolChildService {

    List<SchoolChildDto> getAll();

    SchoolChildDto getById(Long id);

    void add(SchoolChildDtoSave schoolChildDtoSave);

    void edit(Long id, SchoolChildDtoSave schoolChildDtoSave);

    void delete(Long id);
}