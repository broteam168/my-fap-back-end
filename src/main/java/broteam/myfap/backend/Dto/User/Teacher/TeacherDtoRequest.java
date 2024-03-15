package broteam.myfap.backend.Dto.User.Teacher;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TeacherDtoRequest {
    private int UserId;
    private int Salary;
    private int SchoolId;
    private Date CreatAt;
}
