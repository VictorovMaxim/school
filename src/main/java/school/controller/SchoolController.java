//package school.controller;
//
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.web.bind.annotation.*;
//import school.model.dto.schoolChild.SchoolDto;
//import school.service.SchoolService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/schools")
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//public class SchoolController {
//
//    SchoolService service;
//
//    @GetMapping
//    public List<SchoolDto> getAll() {
//        return service.getAll();
//    }
//
//    @PostMapping
//    public void add(@RequestBody SchoolDto schoolDto) {
//        service.add(schoolDto);
//    }
//
//    @DeleteMapping("/{number}")
//    public void delete(@PathVariable String number) {
//        service.delete(number);
//    }
//}