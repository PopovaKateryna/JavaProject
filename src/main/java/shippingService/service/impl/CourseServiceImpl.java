package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.CourseDTO;
import shippingService.entity.Course;
import shippingService.mapper.MapperCourse;
import shippingService.repository.CourseRepository;
import shippingService.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MapperCourse mapperCourse = new MapperCourse();

    @Override
    public CourseDTO create(CourseDTO dto) {
        Course course = mapperCourse.toEntity(dto);
        courseRepository.save(course);
        return mapperCourse.toDto(course);
    }

    @Override
    public CourseDTO read(Long id) {
        return mapperCourse.toDto(courseRepository.findById(id).orElseThrow());
    }

    @Override
    public void update(CourseDTO dto) {
        Course course = mapperCourse.toEntity(dto);
        courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(courseRepository.findById(id).orElseThrow());
    }

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(mapperCourse::toDto).collect(Collectors.toList());
    }
}
