package broteam.myfap.backend.Models.User;

import broteam.myfap.backend.Models.Enums.RoleType;
import broteam.myfap.backend.Models.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "S_User")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "S_User_Role",
            joinColumns = @JoinColumn(name = "userid", referencedColumnName = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id")
    )
    @JsonManagedReference
    @Column(name = "Role")
    private List<Role> roles;
}