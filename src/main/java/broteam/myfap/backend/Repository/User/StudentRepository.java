package broteam.myfap.backend.Repository.User;


import broteam.myfap.backend.Models.User.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value ="SELECT u.UserId, u.UserName, u.Phone, u.Mail, u.Address, u.LastLogin, u.IsActive FROM Student t inner join User u on t.UserId = u.UserId ORDER BY u.UserId DESC OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY;", nativeQuery = true)
    List<Student> findAllStudent(@Param("size") int size, @Param("offset") int offset);
    @Query(value = "Select count(*)from Teacher t inner join User u on t.UserId = u.UserId;", nativeQuery = true)
    long count();
//    @Query("select u.UserName FROM Student t inner join User u on t.UserId = u.UserId where u.UserName = :username")
//    Optional<Student> findByStudentName(@Param("username") String UserName);

    @Query(value = "INSERT INTO S_User_Role (userid, roleid) VALUES (:userId, 4)", nativeQuery = true)
    void setRoleStudent(@Param("userId") int userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM S_User_Role WHERE UserId = :userId", nativeQuery = true)
    void removeUserRole(@Param("userId") int userId);
}