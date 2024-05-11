package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.UserDTO;
import shippingService.entity.User;

import shippingService.mapper.MapperUser;

import shippingService.repository.UserRepository;
import shippingService.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static shippingService.enums.UserRole.USER;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapperUser mapperUser = new MapperUser();

    @Override
    public UserDTO create(UserDTO dto) {
        User user = mapperUser.toEntity(dto);
        userRepository.save(user);
        return mapperUser.toDto(user);
    }

    @Override
    public UserDTO read(Long id) {
        return mapperUser.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void update(UserDTO dto) {
        User user = mapperUser.toEntity(dto);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(mapperUser::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO registerUser(UserDTO admin) {
        admin.setUserRole(USER);
        UserDTO user = new UserDTO(admin.getId(), admin.getEmail(), admin.getPassword(),
                admin.getFirstName(), admin.getLastName(), admin.getUserRole(), admin.isUserStatus());
        userRepository.save(mapperUser.toEntity(user));
        return user;
    }

}
