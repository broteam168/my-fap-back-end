package broteam.myfap.backend.Dto.User.Student;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDtoRequest {
    private int UserId;
    @NotEmpty
    private String Major;
    private int Semester;
    @NotEmpty
    private String Schorlarship;
    private int SchoolId;
}
