package broteam.myfap.backend.Dto.Academic;

import broteam.myfap.backend.Models.Academic.Subject;
import broteam.myfap.backend.Models.Major.SubMajor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private int subMajorId;
    private int semester;

    @JsonProperty("createAt" )
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+7")
    private Date createAt;
}
