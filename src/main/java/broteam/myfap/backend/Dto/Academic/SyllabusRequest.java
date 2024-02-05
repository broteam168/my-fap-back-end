package broteam.myfap.backend.Dto.Academic;

import broteam.myfap.backend.Models.Academic.Subject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SyllabusRequest {
    private int id;
    private String studentTasks;
    private String tools;
    private int scoringScale;
    private int markMin;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date approvedDate;
    private int slot;
    private int subjectId;
}
