package broteam.myfap.backend.Repository.User;

import broteam.myfap.backend.Models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value ="SELECT * FROM User u ORDER BY u.UserId DESC OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY;", nativeQuery = true)
    List<User> findAllUser(@Param("size") int size, @Param("offset") int offset);
    @Query(value = "SELECT COUNT(*) FROM User;", nativeQuery = true)
    long count();
    @Query("select u from User u where u.UserName = :username")
    Optional<User> findByUserName(@Param("username") String UserName);


}