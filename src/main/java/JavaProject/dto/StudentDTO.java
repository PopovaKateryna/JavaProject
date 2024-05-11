package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Course;
import shippingService.enums.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;

    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private UserRole userRole;

    @NotNull
    private String nameCourse;

    @NotNull
    private Double avarageMark;

    @NotNull
    private boolean userStatus;


}

