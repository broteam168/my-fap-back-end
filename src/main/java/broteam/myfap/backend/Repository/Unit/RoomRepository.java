package broteam.myfap.backend.Repository.Unit;


import broteam.myfap.backend.Models.Unit.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("select c from Room c where c.SchoolId = :id")
    List<Room> findBySchoolId(int  id);
}
