package broteam.myfap.backend.Service.User;

import broteam.myfap.backend.Converter.User.UserConverter;
import broteam.myfap.backend.Dto.User.UserDto;
import broteam.myfap.backend.Dto.User.UserDtoRequest;
import broteam.myfap.backend.Exception.User.UserException;
import broteam.myfap.backend.Models.User;
import broteam.myfap.backend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<UserDto> getAllUser(int size, int page) {
        int offset = (page - 1) * size;
        List<UserDto> results = new ArrayList<>();
        for (User userList : userRepository.findAllUser(size, offset)) {
            results.add(userConverter.toDto(userList));
        }
        return results;
    }

    @Override
    public User getDetailUser(int userId) {
        // Sử dụng findById để user dựa trên id
        try {
            return userRepository.findById(userId).orElseThrow(() -> new BadRequestException("Không tìm thấy user với ID: " + userId));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long countUser() {
        return userRepository.count();
    }

    @Override
    public List<UserDto> fillAllB() {
        List<UserDto> results = new ArrayList<>();
        for (User school : userRepository.findAll()) {
            results.add(userConverter.toDto(school));
        }
        return results;
    }

    @Override
    public UserDto createUser(UserDtoRequest userDto) {
        Optional<User> exists = userRepository.findByUserName(userDto.getUserName());
        if (exists.isPresent()) {
            throw new UserException("User đã tồn tại trong hệ thống.");
        }
        User savedUser = userConverter.toEntity(userDto);
        savedUser.setUserPassword(passwordEncoder.encode(userDto.getUserName()));
        userRepository.save(savedUser);
        return userConverter.toDto(savedUser);
    }

    @Override
    public UserDto updateUser(int userId, UserDtoRequest userDto) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            throw new UserException("User không tồn tại.");
        }
        existingUser.setUserName(userDto.getUserName());
        existingUser.setPhone(userDto.getPhone());
        existingUser.setMail(userDto.getMail());
        existingUser.setAddress(userDto.getAddress());
        existingUser.setLastLogin(userDto.getLastLogin());
        userRepository.save(existingUser);
        return userConverter.toDto(existingUser);
    }

    @Override
    @Transactional
    public void deleteUserById(int userId) {
        boolean exists = userRepository.existsById(userId);

        if (exists) {
            userRepository.deleteById(userId);
        } else {
            throw new UserException("Không tìm thấy khách hàng với ID: " + userId);
        }
    }


}
