package broteam.myfap.backend.Repository.Academic;

import broteam.myfap.backend.Models.Academic.Curiculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CuriculumRespository extends JpaRepository<Curiculum, Integer> {

    @Query("select c from Curiculum c where c.subMajorId = :subMajorId")
    Optional<Curiculum> findCuriculumBySubMajorId(@Param("subMajorId") int subMajorId);

    Curiculum findById(int id);


}
