package broteam.myfap.backend.Models.Unit;

import broteam.myfap.backend.Models.Enums.MajorCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "M_Major")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Major {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String Name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category")
    private MajorCategory Category;

    @Column(name = "DegreeLevel")
    private String DegreeLevel;

    @Column(name = "FullName")
    private String FullName;

    @Column(name = "Description")
    private String Description;

    @Column(name = "IsActive")
    private boolean IsActive;
}
