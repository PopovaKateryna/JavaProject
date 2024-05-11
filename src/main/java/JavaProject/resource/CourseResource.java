package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.CourseDTO;
import shippingService.dto.UserDTO;
import shippingService.enums.UserRole;
import shippingService.repository.UserRepository;
import shippingService.service.CourseService;
import shippingService.service.impl.CourseServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/course")
public class CourseResource {
    @Autowired
    private CourseService courseService = new CourseServiceImpl();
    @Autowired UserRepository userRepository;

    @PostMapping("/create")
    public String create(@Valid @RequestBody final CourseDTO courseDTO) {
        courseService.create(courseDTO);
        return "All good";
    }

    @GetMapping("/{id}")
    public CourseDTO read(final @PathVariable Long id) {
        return courseService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<CourseDTO> update(@RequestBody CourseDTO courseDTO) {
        courseService.update(courseDTO);
        return ResponseEntity.ok(courseDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        CourseDTO courseDTO = courseService.read(id);
        courseService.delete(id);
        return "User:" + courseDTO.toString();
    }

    @GetMapping(value = "/all")
    public List<CourseDTO> getAll() {
        return courseService.getAll();
    }


}


