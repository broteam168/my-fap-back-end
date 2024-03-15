package broteam.myfap.backend.Repository.User;

import broteam.myfap.backend.Models.User.Teacher;
import broteam.myfap.backend.Models.User.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value ="SELECT u.UserId, u.UserName, u.Phone, u.Mail, u.Address, u.LastLogin, u.IsActive FROM Teacher t inner join User u on t.UserId = u.UserId ORDER BY u.UserId DESC OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY;", nativeQuery = true)
    List<Teacher> findAllTeacher(@Param("size") int size, @Param("offset") int offset);
    @Query(value = "Select count(*)from Teacher t inner join User u on t.UserId = u.UserId;", nativeQuery = true)
    long count();
//    @Query("select u.UserName FROM Teacher t inner join User u on t.UserId = u.UserId where u.UserName = :username")
//    Optional<Teacher> findByTeacherName(@Param("username") String UserName);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO S_User_Role (userid, roleid) VALUES (:userId, 3)", nativeQuery = true)
    void setRoleTeacher(@Param("userId") int userId);

    @Modifying
    @Query(value = "DELETE FROM S_User_Role WHERE UserId = :userId", nativeQuery = true)
    void removeUserRole(@Param("userId") int userId);
}
