package broteam.myfap.backend.Dto.Academic;

import broteam.myfap.backend.Models.Academic.Subject;

import java.util.Date;

public class SyllabusRequest {
    private int id;
    private String studentTasks;
    private String tools;
    private int scoringScale;
    private int markMin;
    private Date approvedDate;
    private int slot;
    private int subjectId;
}
