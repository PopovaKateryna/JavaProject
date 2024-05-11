package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.CourseDTO;
import shippingService.dto.StudentDTO;
import shippingService.dto.TeacherDTO;
import shippingService.dto.UserDTO;
import shippingService.repository.StudentRepository;
import shippingService.repository.TeacherRepository;
import shippingService.service.StudentService;
import shippingService.service.TeacherService;
import shippingService.service.impl.StudentServiceImpl;
import shippingService.service.impl.TeacherServiceImpl;

@RestController
@RequestMapping("api/techer")
public class TeacherResource {
    @Autowired
    private TeacherService teacherService = new TeacherServiceImpl();
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/{id}")
    public TeacherDTO read(final @PathVariable Long id) {
        return teacherService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<TeacherDTO> update(@RequestBody TeacherDTO teacherDTO) {
        teacherService.update(teacherDTO);
        System.out.println(teacherDTO);
        return null ;//ResponseEntity.ok(userDTO);
    }



}


