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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import school.model.dto.school.SchoolDto;
import school.model.dto.school.SchoolDtoAdd;
import school.service.SchoolService;

import java.util.List;

@Tag(name = "Контроллер учебных заведений", description = "SchoolController")
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
@RequestMapping("/schools")
@ResponseStatus(code = HttpStatus.OK)
@RestController
public class SchoolController {

    SchoolService service;

    @Operation(summary = "Посмотреть все")
    @ApiResponse(
            responseCode = "200",
            description = "ОК",
            content = @Content(mediaType = "application/json", schema = @Schema(
                    implementation = SchoolDto.class)))
    @GetMapping
    public List<SchoolDto> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Посмотреть по номеру")
    @ApiResponse(
            responseCode = "200",
            description = "ОК",
            content = @Content(mediaType = "application/json", schema = @Schema(
                    implementation = SchoolDto.class)))
    @GetMapping("/{number}")
    public SchoolDto getByNumber(
            @Parameter(name= "Номер учебного заведения", example = "Лицей №2")
            @PathVariable String number) {
        return service.getSchoolByNumber(number);
    }

    @Operation(summary = "Добавить")
    @PostMapping
    @ApiResponse(responseCode = "200", description = "Запись добавлена")
    public void add(@RequestBody SchoolDtoAdd schoolDtoAdd) {
        service.add(schoolDtoAdd);
    }

    @Operation(summary = "Изменить")
    @ApiResponse(responseCode = "200", description = "Запись изменена")
    @PostMapping("/{number}")
    public void edit(
            @Parameter(name= "Номер учебного заведения", example = "Лицей №2")
            @PathVariable String number,
            @RequestBody SchoolDtoAdd schoolDtoAdd) {
        service.edit(number, schoolDtoAdd);
    }

    @Operation(summary = "Удалить")
    @ApiResponse(responseCode = "200", description = "Запись удалена")
    @DeleteMapping("/{number}")
    public void delete(
            @Parameter(name= "Номер учебного заведения", example = "Лицей №2")
            @PathVariable String number) {
        service.delete(number);
    }
}