package broteam.myfap.backend.Models.Academic;

import broteam.myfap.backend.Models.Major.SubMajor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "A_Curiculum")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curiculum {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "SubjectId", insertable = false, updatable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "SubMajorId", insertable = false, updatable = false)
    private SubMajor subMajor;

    @Column(name = "Order")
    private int order;

    @Column(name = "Semester")
    private int semester;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "UpdateAt")
    private Date updateAt;
}
