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
    @JoinColumn(name = "Id", insertable = false, updatable = false)
    private Major major;
    @Column(name = "Description")
    private String Description;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private School school;

    @Column(name = "IsActive")
    private boolean IsActive;
}
