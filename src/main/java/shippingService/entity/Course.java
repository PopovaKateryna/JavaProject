package shippingService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_table")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time_start")
    private String timeStart;

    @Column(name = "time_finish")
    private String timeFinish;

    @Column(name = "list_student")
    private String listStudent;

    @Column(name = "day_of_week")
    private String weekDay;


}
