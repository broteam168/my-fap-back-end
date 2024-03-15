package broteam.myfap.backend.Converter.User;

import broteam.myfap.backend.Dto.User.UserDto;
import broteam.myfap.backend.Dto.User.UserDtoRequest;
import broteam.myfap.backend.Models.User.User;
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
        dto.setPhone(entity.getPhone());
        dto.setMail(entity.getMail());
        dto.setAddress(entity.getAddress());
        dto.setLastLogin(entity.getLastLogin());
        dto.setIsActive(entity.isIsActive());
        return dto;
    }

    public User toEntity(UserDto dto){
        User entity = new User();
        entity.setUserId(dto.getUserId());
        entity.setUserName(dto.getUserName());
        entity.setPhone(dto.getPhone());
        entity.setMail(dto.getMail());
        entity.setAddress(dto.getAddress());
        entity.setLastLogin(dto.getLastLogin());
        entity.setIsActive(dto.isIsActive());
        return entity;
    }

    public User toEntity(UserDtoRequest dto){
        User entity = new User();
        entity.setUserName(dto.getUserName());
        entity.setPhone(dto.getPhone());
        entity.setMail(dto.getMail());
        entity.setAddress(dto.getAddress());
        entity.setLastLogin(dto.getLastLogin());
        entity.setIsActive(dto.isIsActive());
        return entity;
    }
}
