package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.StudentDTO;
import shippingService.dto.UserDTO;
import shippingService.entity.Student;
import shippingService.entity.User;

@Component
public class MapperStudent {
    public StudentDTO toDto(final Student user) {
        final StudentDTO dto = new StudentDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserRole(user.getUserRole());
        dto.setNameCourse(user.getCourseName());
        dto.setAvarageMark(user.getAvarageMark());
        dto.setUserStatus(user.isUserStatus());
        return dto;
    }

    public Student toEntity(final StudentDTO dto) {
        final Student user = new Student();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUserRole(dto.getUserRole());
        user.setCourseName(dto.getNameCourse());
        user.setAvarageMark(dto.getAvarageMark());
        user.setUserStatus(dto.isUserStatus());
        return user;
    }
}
