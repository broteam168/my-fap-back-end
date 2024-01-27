package broteam.myfap.backend.Dto.Major;

import broteam.myfap.backend.Models.Enums.MajorCategory;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MajorDto {

    private int id;


    private String Name;

    private MajorCategory Category;


    private String DegreeLevel;


    private String FullName;


    private String Description;
    private boolean IsActive;
}
