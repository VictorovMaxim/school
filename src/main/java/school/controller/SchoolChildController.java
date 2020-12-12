package school.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import school.model.dto.schoolChild.SchoolChildDto;
import school.model.dto.schoolChild.SchoolChildDtoSave;
import school.service.SchoolChildService;

import java.util.List;

@Tag(name = "Контроллер школьников", description = "SchoolChildController")
@ApiResponses({
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
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@ResponseStatus(code = HttpStatus.OK)
@RequestMapping("/schoolchilds")
@RestController
public class SchoolChildController {

    SchoolChildService service;

    @Operation(summary = "Посмотреть все")
    @ApiResponse(
            responseCode = "200",
            description = "ОК",
            content = @Content(mediaType = "application/json", schema = @Schema(
                    implementation = SchoolChildDto.class)))
    @GetMapping
    public List<SchoolChildDto> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Посмотреть по id")
    @ApiResponse(
            responseCode = "200",
            description = "ОК",
            content = @Content(mediaType = "application/json", schema = @Schema(
                    implementation = SchoolChildDto.class)))
    @GetMapping("/{id}")
    public SchoolChildDto getById(@Parameter(example = "1") @PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Добавить")
    @ApiResponse(responseCode = "200", description = "Запись добавлена")
    @PostMapping
    public void add(@RequestBody SchoolChildDtoSave schoolChildDtoSave) {
        service.add(schoolChildDtoSave);
    }

    // Put не существует в HTML 5
    @Operation(summary = "Изменить")
    @ApiResponse(responseCode = "200", description = "Запись изменена")
    @PostMapping("/{id}")
    public void edit(
            @Parameter(example = "1") @PathVariable Long id,
            @RequestBody SchoolChildDtoSave schoolChildDtoSave) {
        service.edit(id, schoolChildDtoSave);
    }

    // Delete тоже, но почему-то он поддерживается
    @Operation(summary = "Удалить")
    @ApiResponse(responseCode = "200", description = "Запись удалена")
    @DeleteMapping("/{id}")
    public void delete(@Parameter(example = "1") @PathVariable Long id) {
        service.delete(id);
    }
}