package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.StudentDTO;
import shippingService.entity.Student;
import shippingService.mapper.MapperStudent;
import shippingService.repository.StudentRepository;
import shippingService.service.StudentService;
import javax.transaction.Transactional;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MapperStudent mapperStudent;

    @Override
    public StudentDTO read(Long id) {
        return mapperStudent.toDto(studentRepository.findById(id).orElseThrow());
    }
    @Override
    public void update(StudentDTO dto) {
        Student student = mapperStudent.toEntity(dto);
        studentRepository.save(student);
    }
}
