package shippingService.service;

import shippingService.dto.CourseDTO;
import shippingService.dto.UserDTO;

import java.util.List;

public interface CourseService {
    CourseDTO create(CourseDTO dto);

    CourseDTO read(Long id);

    void update(CourseDTO dto);

    void delete(Long id);

    List<CourseDTO> getAll();
}
