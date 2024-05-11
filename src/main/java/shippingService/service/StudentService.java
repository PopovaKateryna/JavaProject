package shippingService.service;
import shippingService.dto.CourseDTO;
import shippingService.dto.StudentDTO;


import java.util.List;

public interface StudentService {

    StudentDTO read(Long id);

    void update(StudentDTO dto);

}

