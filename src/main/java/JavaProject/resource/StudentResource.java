package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.CourseDTO;
import shippingService.dto.StudentDTO;
import shippingService.dto.UserDTO;
import shippingService.repository.StudentRepository;
import shippingService.service.StudentService;
import shippingService.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("api/student")
public class StudentResource {
    @Autowired
    private StudentService studentService = new StudentServiceImpl();
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/{id}")
    public StudentDTO read(final @PathVariable Long id) {
        return studentService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO userDTO) {
        studentService.update(userDTO);
        System.out.println(userDTO);
        return null ;//ResponseEntity.ok(userDTO);
    }



}


