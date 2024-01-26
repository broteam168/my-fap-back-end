package broteam.myfap.backend.Models.Unit;

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

    @Column(name = "Category")
    private String Category;

    @Column(name = "DegreeLevel")
    private String DegreeLevel;

    @Column(name = "FullName")
    private String FullName;

    @Column(name = "Description")
    private String Description;
}
