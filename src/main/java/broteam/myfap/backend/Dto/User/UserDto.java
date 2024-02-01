package broteam.myfap.backend.Dto.User;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserDto {
    private int UserId;
    private String UserName;
    private String UserPassword;
    private String Phone;
    private String Mail;
    private String Address;
    private Date LastLogin;
    private boolean IsActive;
}
