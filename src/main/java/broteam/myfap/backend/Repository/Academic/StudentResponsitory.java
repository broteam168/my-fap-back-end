package broteam.myfap.backend.Repository.Academic;

import broteam.myfap.backend.Models.Academic.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResponsitory extends JpaRepository<Student, Integer> {
    Student findById(int id);
}
