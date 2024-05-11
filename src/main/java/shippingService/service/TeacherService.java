package shippingService.service;

import shippingService.dto.TeacherDTO;

public interface TeacherService {
    TeacherDTO read(Long id);

    void update(TeacherDTO dto);

}
