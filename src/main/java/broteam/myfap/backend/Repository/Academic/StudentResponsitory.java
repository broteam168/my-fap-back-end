package broteam.myfap.backend.Repository.Academic;

import broteam.myfap.backend.Models.Academic.Student;
import broteam.myfap.backend.Models.Academic.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentResponsitory extends JpaRepository<Student, Integer> {
    Student findById(int id);

    @Query("select s from Student s where s.userId = :userId")
    Student findByUserId(@Param("userId") int userId);
}
