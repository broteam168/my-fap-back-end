package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.ClassRequest;
import broteam.myfap.backend.Dto.Unit.RoomDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRoomService {

    List<RoomDto> findAllBase();

    List<RoomDto> FindBySchoolId(int id);
}
