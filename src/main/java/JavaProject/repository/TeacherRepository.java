package shippingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingService.entity.Student;
import shippingService.entity.Teacher;
import shippingService.entity.User;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
    Boolean existsByEmail(String email);
}
