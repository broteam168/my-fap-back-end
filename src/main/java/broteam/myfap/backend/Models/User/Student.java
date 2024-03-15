package broteam.myfap.backend.Models.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "A_Student")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id")
    private int Id;

    @Column(name = "UserId")
    private int UserId;

    @Column(name = "Major")
    private String Major;

    @Column(name = "Semester")
    private int Semester;

    @Column(name = "Schorlarship")
    private String Schorlarship;

    @Column(name = "SchoolId")
    private int SchoolId;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId("UserId")
    @JoinColumn(name = "UserId")
    private User user;
}