package broteam.myfap.backend.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "S_user")
@Data
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
}