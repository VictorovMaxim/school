package school.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import school.model.dto.schoolChild.SchoolChildDto;
import school.model.dto.schoolChild.SchoolChildDtoSave;
import school.model.entity.SchoolChild;

@Mapper(componentModel = "spring")
public interface SchoolChildMapper {

    SchoolChildDto schoolChildToSchoolChildDto(SchoolChild schoolChild);

    @Mapping(target = "id", ignore = true)
    SchoolChild schoolChildDtoToSchoolChild(SchoolChildDtoSave schoolChildDtoSave);
}