package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Dto.Academic.CuriculumDto;

import java.util.List;

public interface ICuriculumService {
    List<CuriculumDto> findAllBase();

    CuriculumDto findCuriculumById(int id);
    
}
