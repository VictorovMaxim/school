package school.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import school.model.dto.schoolChild.SchoolChildDto;
import school.model.dto.schoolChild.SchoolChildDtoSave;
import school.service.SchoolChildService;

import java.util.List;

@RestController
@RequestMapping("/schoolchilds")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@ResponseStatus(code = HttpStatus.OK)
@Tag(name = "Контроллер школьников", description = "SchoolChildController")
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "ОК"),
        @ApiResponse(
                responseCode = "400",
                description = "Ошибка клиента",
                content = @Content(mediaType = "application/json", schema = @Schema(
                        implementation = ResponseErrorModel.class))),
        @ApiResponse(
                responseCode = "500",
                description = "Ошибка сервера",
                content = @Content(mediaType = "application/json", schema = @Schema(
                        implementation = ResponseErrorModel.class)))
})
public class SchoolChildController {

    SchoolChildService service;

    @GetMapping
    public List<SchoolChildDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void add(@RequestBody SchoolChildDtoSave schoolChildDtoSave) {
        service.add(schoolChildDtoSave);
    }

    // Put не существует в HTML 5
    @PostMapping("/{id}")
    public void edit(
            @PathVariable Long id,
            @RequestBody SchoolChildDtoSave schoolChildDtoSave) {
        service.edit(id, schoolChildDtoSave);
    }

    // Delete тоже, но почему-то он поддерживается
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}