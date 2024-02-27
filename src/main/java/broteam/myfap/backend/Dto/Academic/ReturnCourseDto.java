package broteam.myfap.backend.Dto.Academic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnCourseDto {
    private int id;

    private String Name;
    private String Status;
    private String Slots;
    private String Days;
    private int ClassId;
    private int SubMajorId;

    private int RoomId;
    private int SemesterId;
    private int SubjectId;
    private int TeacherId;
}
