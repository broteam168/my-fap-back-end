package broteam.myfap.backend.Models.User;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "A_Teacher")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id")
    private int Id;

    @Column(name = "UserId")
    private int UserId;

    @Column(name = "SchoolId")
    private int SchoolId;

    @Column(name = "Salary")
    private int Salary;

    @Column(name = "CreatAt")
    private Date CreatAt;
 
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId("UserId")
    @JoinColumn(name = "UserId")
    private User user;
}