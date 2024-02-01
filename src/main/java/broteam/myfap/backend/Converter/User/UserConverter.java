package broteam.myfap.backend.Converter.User;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.User.UserDto;
import broteam.myfap.backend.Models.Unit.Major;
import broteam.myfap.backend.Models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto toDto(User entity){
        UserDto dto = new UserDto();
        if(entity.getUserId() > 0 ){
            dto.setUserId(entity.getUserId());
        }
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setUserPassword(entity.getUserPassword());
        dto.setPhone(entity.getPhone());
        dto.setMail(entity.getMail());
        dto.setAddress(entity.getAddress());
        dto.setLastLogin(entity.getLastLogin());
        dto.setIsActive(entity.isIsActive());
        return dto;
    }
}
