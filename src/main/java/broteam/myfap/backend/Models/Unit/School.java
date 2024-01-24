package broteam.myfap.backend.Models.Unit;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "U_School")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    private int Name;

    @Column(name = "Description")
    private int Description;

    @Column(name = "Location")
    private int Location;

    @Column(name = "Phone")
    private int Phone;

    @Column(name = "IsActive")
    private boolean IsActive;

    @Column(name = "Rule")
    private String Rule;
}