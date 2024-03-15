package broteam.myfap.backend.Dto.User.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private int id;
    private int UserId;
    private String Major;
    private int Semester;
    private String Schorlarship;
    private int SchoolId;
}
