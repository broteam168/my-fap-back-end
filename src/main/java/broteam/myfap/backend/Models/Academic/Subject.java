package broteam.myfap.backend.Models.Academic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "A_Subject")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subjectCode")
    private String subjectCode;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "minAvgMarkToPass")
    private int minAvgMarkToPass;

    @Column(name = "description")
    private String description;

    @Column(name = "credits")
    private String credits;

    @Column(name = "prerequisite")
    private int prerequisite;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)

    private Subject prerequisiteSubject;
}
