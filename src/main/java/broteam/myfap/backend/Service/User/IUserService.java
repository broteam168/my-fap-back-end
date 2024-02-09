package broteam.myfap.backend.Service.User;

import broteam.myfap.backend.Dto.User.UserDto;
import broteam.myfap.backend.Dto.User.UserDtoRequest;
import broteam.myfap.backend.Models.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {
    List<UserDto> getAllUser(int size, int page);

    User getDetailUser(int userId);

    long countUser();

    List<UserDto> fillAllB();

    UserDto createUser(UserDtoRequest userDto);

    UserDto updateUser(int userId, UserDtoRequest userDto);

    @Transactional
    void deleteUserById(int customerId);
}
