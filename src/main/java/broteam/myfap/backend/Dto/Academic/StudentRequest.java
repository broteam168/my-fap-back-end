package broteam.myfap.backend.Dto.Academic;

import broteam.myfap.backend.Models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private int id;
    private User user;
    private int subMajorId;
    private int semester;
    private int schoolId;
    private int classId;
    private String studentCode;
}
