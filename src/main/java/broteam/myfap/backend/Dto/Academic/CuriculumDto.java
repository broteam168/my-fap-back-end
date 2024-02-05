package broteam.myfap.backend.Dto.Academic;

import broteam.myfap.backend.Models.Academic.Subject;
import broteam.myfap.backend.Models.Major.SubMajor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuriculumDto {
    private int id;
    private Subject subject;
    private SubMajor subMajor;
    private int order;
    private int semester;
    private Date createAt;
    private Date updateAt;
}
