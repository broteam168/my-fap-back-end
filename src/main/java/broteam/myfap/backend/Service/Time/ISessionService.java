package broteam.myfap.backend.Service.Time;

import broteam.myfap.backend.Dto.Time.SessionDto;
import broteam.myfap.backend.Dto.Time.SlotDto;
import broteam.myfap.backend.Dto.Time.SlotRequestDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ISessionService {


    List<SessionDto> findAllBase();

    List<SessionDto> findBySchoolAndClass(Optional<Integer> schoolId, Optional<Integer> classid);
}
