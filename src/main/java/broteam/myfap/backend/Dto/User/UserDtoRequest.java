package broteam.myfap.backend.Dto.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDtoRequest {
    @NotEmpty
    private String UserName;
    @NotEmpty
    private String Phone;
    @NotEmpty
    private String Mail;
    @NotEmpty
    private String Address;
    private Date LastLogin;
    private boolean IsActive;
}
