package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Dto.Academic.CuriculumDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ICuriculumService {
    List<CuriculumDto> findAllBase();

    CuriculumDto findCuriculumById(int id);

    List<CuriculumDto> findCuriBySubMajorId(int subMajorId);

    @Transactional
    CuriculumDto deleteCuriculum(int id);

    @Transactional
    CuriculumDto createNewCuriculum(CuriculumDto newCuriculum);

    @Transactional
    CuriculumDto updateCuriculum(int id, CuriculumDto newCuriculum);
}
