package broteam.myfap.backend.Service.User;

import broteam.myfap.backend.Dto.User.UserDto;
import broteam.myfap.backend.Models.User;

import java.util.List;

public interface IUserService {
    List<UserDto> getAllUser(int size, int page);

    User getDetailUser(int userId);

    long countUser();

    List<UserDto> fillAllB();
}
