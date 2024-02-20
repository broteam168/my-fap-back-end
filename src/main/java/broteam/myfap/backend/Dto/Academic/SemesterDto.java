package broteam.myfap.backend.Dto.Academic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterDto {
    private int id;
    private String Name;
    private int Year;
    private int Order;
    private Date StartDate;
    private Date EndDate;
    private String Description;
    private boolean IsActive;
}
