package shippingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingService.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
