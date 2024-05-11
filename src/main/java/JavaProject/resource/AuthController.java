package shippingService.resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shippingService.dto.JwtResponse;
import shippingService.dto.LoginRequest;
import shippingService.dto.MessageResponse;
import shippingService.dto.SignupRequest;
import shippingService.entity.Student;
import shippingService.entity.Teacher;
import shippingService.entity.User;
import shippingService.enums.UserRole;
import shippingService.repository.StudentRepository;
import shippingService.repository.TeacherRepository;
import shippingService.repository.UserRepository;
import shippingService.security.JwtUtils;
import shippingService.service.impl.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.joining(", ")); // Правильний роздільник - кома

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }



    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        // Перевірка, чи електронна адреса вже використовується
        if (userRepository.existsByEmail(signUpRequest.getEmail()) ||
                studentRepository.existsByEmail(signUpRequest.getEmail()) ||
                teacherRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        System.out.println("\t"+ signUpRequest + "\t");
        switch (signUpRequest.getUserRole()) {
            case STUDENT:
                Student student = new Student();
                student.setEmail(signUpRequest.getEmail());
                student.setPassword(encoder.encode(signUpRequest.getPassword()));
                student.setFirstName(signUpRequest.getFirstName());
                student.setLastName(signUpRequest.getLastName());
                student.setUserRole(signUpRequest.getUserRole());
                student.setCourseName(signUpRequest.getCourseName());
                student.setAvarageMark(signUpRequest.getAvarageMark());
                student.setUserStatus(signUpRequest.isUserStatus());
                studentRepository.save(student);
                break;
            case TEACHER:
                Teacher teacher = new Teacher();
                teacher.setEmail(signUpRequest.getEmail());
                teacher.setPassword(encoder.encode(signUpRequest.getPassword()));
                teacher.setFirstName(signUpRequest.getFirstName());
                teacher.setLastName(signUpRequest.getLastName());
                teacher.setUserRole(signUpRequest.getUserRole());
                teacher.setCourseName(signUpRequest.getCourseName());
                teacher.setUserStatus(signUpRequest.isUserStatus());
                teacherRepository.save(teacher);
                break;
            case USER:
                User user = new User();
                user.setEmail(signUpRequest.getEmail());
                user.setPassword(encoder.encode(signUpRequest.getPassword()));
                user.setFirstName(signUpRequest.getFirstName());
                user.setLastName(signUpRequest.getLastName());
                user.setUserRole(signUpRequest.getUserRole());
                user.setUserStatus(signUpRequest.isUserStatus());
                userRepository.save(user);
                break;
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
