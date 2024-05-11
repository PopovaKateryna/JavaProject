package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Student;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String timeStart;
    @NotNull
    private String timeFinish;
    @NotNull
    private String weekDay;
    @NotNull
    private String listStudent;
}


