package broteam.myfap.backend.Models.Unit;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    private String Name;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Location")
    private String Location;

    @Column(name = "Phone")
    private String Phone;

    @Column(name = "IsActive")
    private boolean IsActive;

    @OneToMany(mappedBy = "userEntity")
    private List<Class> warehouseBalanceList;
}