package broteam.myfap.backend.Service.User;

import broteam.myfap.backend.Converter.User.UserConverter;
import broteam.myfap.backend.Dto.User.UserDto;
import broteam.myfap.backend.Models.User;
import broteam.myfap.backend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    @Override
    public List<UserDto> getAllUser(int size, int page) {
        int offset = (page - 1) * size;
        List<UserDto> results = new ArrayList<>();
        for (User userList : userRepository.findAllUser(size,offset)){
            results.add(userConverter.toDto(userList));
        };
        return results;
    }
    @Override
    public User getDetailUser(int userId) {
        // Sử dụng findById để user dựa trên id
        try {
            return userRepository.findById(userId)
                    .orElseThrow(() -> new BadRequestException("Không tìm thấy user với ID: " + userId));
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
        for(User school :  userRepository.findAll())
        {
            results.add(userConverter.toDto(school));
        };
        return  results;
    }

}
