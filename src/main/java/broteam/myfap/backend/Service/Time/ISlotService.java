package broteam.myfap.backend.Service.Time;

import broteam.myfap.backend.Dto.Time.GroupSlotDto;
import broteam.myfap.backend.Dto.Time.GroupSlotRequestDto;
import broteam.myfap.backend.Dto.Time.SlotDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISlotService {


    List<SlotDto> findAllBase();

    List<SlotDto> FindByGroupId(int id);
}
