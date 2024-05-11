package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.CourseDTO;
import shippingService.entity.Course;

@Component
public class MapperCourse {
    public CourseDTO toDto(final Course course) {
        final CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setTimeStart(course.getTimeStart());
        dto.setTimeFinish(course.getTimeFinish());
        dto.setWeekDay(course.getWeekDay());
        dto.setListStudent(course.getListStudent());
        return dto;
    }

    public Course toEntity(final CourseDTO dto) {
        final Course course = new Course();
        course.setId(dto.getId());
        course.setName(dto.getName());
        course.setTimeStart(dto.getTimeStart());
        course.setTimeFinish(dto.getTimeFinish());
        course.setWeekDay(dto.getWeekDay());
        course.setListStudent(dto.getListStudent());
        return course;
    }
}
