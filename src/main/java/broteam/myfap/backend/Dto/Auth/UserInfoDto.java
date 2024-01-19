package broteam.myfap.backend.Dto.Auth;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;



    @Getter
    @Setter
    public class UserInfoDto {

        private String UserName;
        private String Phone;
        private String Mail;
        private String Address;
        private Date LastLogin;
        private boolean IsActive;
        private boolean IsTeacher;
        private boolean IsAdmin;

}
