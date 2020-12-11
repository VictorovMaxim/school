//package school.service;
//
//import com.google.common.collect.Lists;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import school.model.dto.schoolChild.SchoolDto;
//import school.model.mapper.SchoolMapper;
//import school.repo.SchoolRepo;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//public class SchoolServiceImpl implements SchoolService {
//
//    SchoolRepo repo;
//
//    SchoolMapper mapper;
//
//    @Transactional(propagation = Propagation.NEVER)
//    @Override
//    public  List<SchoolDto> getAll() {
//        return Lists.newArrayList(repo.findAll()).stream()
//                    .map(school -> mapper.map(school))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void add(SchoolDto schoolDto) {
//        repo.save(mapper.map(schoolDto));
//    }
//
//    @Override
//    public void delete(String number) {
//        repo.deleteByNumber(number);
//    }
//}