package broteam.myfap.backend.Dto.Time;

import broteam.myfap.backend.Models.Academic.Course;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;


@Getter
@Setter

public class SessionDto {
   private int id;
   private String Name;
   private Time StartTime;
   private Time EndTime;
   private Date DateDay;
   private int CourseId;
   private String Status;
   private Course course;
}
