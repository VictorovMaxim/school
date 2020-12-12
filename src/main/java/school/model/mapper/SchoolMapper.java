package school.model.mapper;

import org.mapstruct.Mapper;
import school.model.dto.school.SchoolDto;
import school.model.dto.school.SchoolDtoAdd;
import school.model.entity.School;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    SchoolDto schoolToSchoolDto(School school);

    School schoolDtoToSchool(SchoolDtoAdd schoolDtoAdd);
}