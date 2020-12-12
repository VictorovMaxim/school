package school.service;

import school.model.dto.school.SchoolDto;
import school.model.dto.school.SchoolDtoAdd;

import java.util.List;

public interface SchoolService {

    List<SchoolDto> getAll();

    SchoolDto getSchoolByNumber(String number);

    void add(SchoolDtoAdd schoolDtoAdd);

    void edit(String number, SchoolDtoAdd schoolDtoAdd);

    void delete(String number) throws RuntimeException;
}