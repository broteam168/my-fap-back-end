package broteam.myfap.backend.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "S_user")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "UserId")
    private int UserId;

    @Column(name = "UserName")
    private String UserName;

    @Column(name = "UserPassword")
    private String UserPassword;

    @Column(name = "Phone")
    private String Phone;
    @Column(name = "Mail")
    private String Mail;
    @Column(name = "Address")
    private String Address;
    @Column(name = "LastLogin")
    private Date LastLogin;
    @Column(name = "IsActive")
    private boolean IsActive;
    @Column(name = "IsTeacher")
    private boolean IsTeacher;
    @Column(name = "IsAdmin")
    private boolean IsAdmin;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "S_User_Role",
            joinColumns = @JoinColumn(name = "userid", referencedColumnName = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id")
    )
    @JsonManagedReference
    private List<Role> roles;
}