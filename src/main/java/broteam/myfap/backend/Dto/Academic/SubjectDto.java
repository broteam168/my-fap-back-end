package broteam.myfap.backend.Dto.Academic;

import broteam.myfap.backend.Models.Academic.Subject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectDto {
    private int id;
    private String subjectCode;
    private String name;
    private String type;
    private String status;
    private String description;
    private String credits;
    private int prerequisite;

    @JsonManagedReference
    private SubjectDto prerequisiteSubject;
}
