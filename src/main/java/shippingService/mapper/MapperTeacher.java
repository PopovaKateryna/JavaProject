package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.StudentDTO;
import shippingService.dto.TeacherDTO;
import shippingService.dto.UserDTO;
import shippingService.entity.Student;
import shippingService.entity.Teacher;
import shippingService.entity.User;

@Component
public class MapperTeacher {
    public TeacherDTO toDto(final Teacher user) {
        final TeacherDTO dto = new TeacherDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserRole(user.getUserRole());
        dto.setUserStatus(user.isUserStatus());
        dto.setCourseName(user.getCourseName());
        return dto;
    }

    public Teacher toEntity(final TeacherDTO dto) {
        final Teacher user = new Teacher();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUserRole(dto.getUserRole());
        user.setUserStatus(dto.isUserStatus());
        user.setCourseName(dto.getCourseName());
        return user;
    }
}
