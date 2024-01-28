package broteam.myfap.backend.Dto.Unit;

import broteam.myfap.backend.Models.Unit.Major;
import broteam.myfap.backend.Models.Unit.School;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDto {
    private int id;
    private String Name;
    private Major major;
    private String Description;
    private int school;
    private boolean IsActive;
}
