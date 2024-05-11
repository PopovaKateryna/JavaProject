package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shippingService.entity.Student;
import shippingService.entity.Teacher;
import shippingService.entity.User;
import shippingService.repository.StudentRepository;
import shippingService.repository.TeacherRepository;
import shippingService.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);
        if (userOptional.isPresent()) {
            return UserDetailsImpl.build(userOptional.get());
        }
        /*
        Optional<Student> studentOptional = studentRepository.findByEmail(username);
        if (studentOptional.isPresent()) {
            return UserDetailsImpl.build(studentOptional.get());
        }

        Optional<Teacher> teacherOptional = teacherRepository.findByEmail(username);
        if (teacherOptional.isPresent()) {
            return UserDetailsImpl.build(teacherOptional.get());
        }*/

        throw new UsernameNotFoundException("User Not Found with username: " + username);
    }
}
