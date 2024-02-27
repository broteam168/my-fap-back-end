package broteam.myfap.backend.Models.Academic;

import broteam.myfap.backend.Models.Major.SubMajor2;
import broteam.myfap.backend.Models.Unit.Class;
import broteam.myfap.backend.Models.Unit.Room;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "A_Course")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String Name;


    @Column(name = "Status")
    private String Status;

    @Column(name = "Slots")
    private String Slots;

    @Column(name = "Days")
    private String Days;


    @Column(name = "ClassId")
    private int ClassId;

    @Column(name = "SubMajorId")
    private int SubMajorId;


    @Column(name = "RoomId")
    private int RoomId;;

    @Column(name = "SemesterId")
    private int SemesterId;

    @Column(name = "SubjectId")
    private int SubjectId;

    @Column(name = "TeacherId")
    private int TeacherId;


}
