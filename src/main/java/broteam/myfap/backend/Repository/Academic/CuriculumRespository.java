package broteam.myfap.backend.Repository.Academic;

import broteam.myfap.backend.Models.Academic.Curiculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CuriculumRespository extends JpaRepository<Curiculum, Integer> {
    Curiculum findById(int id);
}
