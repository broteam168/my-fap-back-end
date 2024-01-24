package broteam.myfap.backend.Dto.Unit;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class SchoolDto {
   private int id;

    private String Name;

    private String Description;

    private String Location;

   private String Phone;

    private boolean IsActive;

     private String Rule;
}
