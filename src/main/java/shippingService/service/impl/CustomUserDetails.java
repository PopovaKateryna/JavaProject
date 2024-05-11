package shippingService.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import shippingService.entity.Student;
import shippingService.entity.Teacher;
import shippingService.entity.User;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // Конструктор для User
    public CustomUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.authorities = Collections.emptyList(); // Порожній список прав
    }

    // Конструктор для Student
    public CustomUserDetails(Student student) {
        this.username = student.getEmail();
        this.password = student.getPassword();
        this.authorities = Collections.emptyList(); // Порожній список прав
    }

    // Конструктор для Teacher
    public CustomUserDetails(Teacher teacher) {
        this.username = teacher.getEmail();
        this.password = teacher.getPassword();
        this.authorities = Collections.emptyList(); // Порожній список прав
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
