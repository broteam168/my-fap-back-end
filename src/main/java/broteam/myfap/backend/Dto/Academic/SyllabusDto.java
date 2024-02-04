package broteam.myfap.backend.Dto.Academic;

import broteam.myfap.backend.Models.Academic.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SyllabusDto {
    private int id;
    private String studentTasks;
    private String tools;
    private int scoringScale;
    private int markMin;
    private Date approvedDate;
    private int slot;
    private Subject subject;
}
