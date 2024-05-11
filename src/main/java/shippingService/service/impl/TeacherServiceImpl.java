package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.StudentDTO;
import shippingService.dto.TeacherDTO;
import shippingService.entity.Student;
import shippingService.mapper.MapperStudent;
import shippingService.repository.StudentRepository;
import shippingService.service.StudentService;
import shippingService.service.TeacherService;

import javax.transaction.Transactional;


@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Override
    public TeacherDTO read(Long id) {
        return null;
    }

    @Override
    public void update(TeacherDTO dto) {

    }
}
