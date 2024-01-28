package broteam.myfap.backend.Models.Unit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "U_Class")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String Name;
    @ManyToOne
    @JoinColumn(name = "MajorId", insertable = false, updatable = false)
    private Major major;
    @Column(name = "Description")
    private String Description;

    @Column(name = "SchoolId")

    private int school;

    @Column(name = "IsActive")
    private boolean IsActive;
}
