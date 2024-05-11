package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.enums.UserRole;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole userRole;
    private boolean userStatus;
    private String courseName;
    private Double avarageMark;
}
