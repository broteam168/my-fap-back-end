package broteam.myfap.backend.Dto.Academic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;
    private int userId;
    private int subMajorId;
    private int semester;
    private int schoolId;
    private int classId;
    private String studentCode;
}
