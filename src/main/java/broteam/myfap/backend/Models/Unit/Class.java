package broteam.myfap.backend.Models.Unit;

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
    private Major major;
    @Column(name = "Description")
    private String Description;

    @ManyToOne
    private School school;

}
