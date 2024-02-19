package broteam.myfap.backend.Service.Time;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.MajorRequestDto;
import broteam.myfap.backend.Dto.Time.GroupSlotDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGroupSlotService {

    List<GroupSlotDto> findAllBase();
}
