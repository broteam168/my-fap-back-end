package broteam.myfap.backend.Repository.Unit;

import broteam.myfap.backend.Models.Unit.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<School, Integer> {
}
