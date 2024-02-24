package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Converter.Academic.AcademicConverter;
import broteam.myfap.backend.Dto.Academic.CuriculumDto;
import broteam.myfap.backend.Exception.Academic.CuriculumException;
import broteam.myfap.backend.Exception.NotFoundException;
import broteam.myfap.backend.Models.Academic.Curiculum;
import broteam.myfap.backend.Models.Academic.Syllabus;
import broteam.myfap.backend.Repository.Academic.CuriculumRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuriculumService implements ICuriculumService{
    private final CuriculumRespository curiculumRespository;
    private final AcademicConverter academicConverter;
    private final SubjectService subjectService;

    @Override
    public List<CuriculumDto> findAllBase() {
        List<CuriculumDto> results = new ArrayList<>();
        for (Curiculum curiculum : curiculumRespository.findAll()) {
            results.add(academicConverter.toDto(curiculum));
        }
        return results;
    }

    @Override
    public CuriculumDto findCuriculumById(int id) {
        Curiculum gotCuriculum = curiculumRespository.findById(id);
        if (gotCuriculum == null) {
            throw new NotFoundException("Cannot find curriculum");
        }
        return academicConverter.toDto(gotCuriculum);
    }

    @Override
    public List<CuriculumDto> findCuriBySubMajorId(int subMajorId) {
        List<CuriculumDto> results = new ArrayList<>();


    }

    @Override
    public CuriculumDto deleteCuriculum(int id) {
        Curiculum foundCuriculum = curiculumRespository.findById(id);
        if (foundCuriculum == null) {
            throw new NotFoundException("Cannot find Curiculum");
        }
        curiculumRespository.deleteById(id);
        return academicConverter.toDto(foundCuriculum);
    }

    @Override
    public CuriculumDto createNewCuriculum(CuriculumDto newCuriculum) {
        Curiculum baseCuriculum = academicConverter.toEntity(newCuriculum);

        Curiculum createdCuriculum = curiculumRespository.save(baseCuriculum);
        return academicConverter.toDto(createdCuriculum);
    }

    @Override
    public CuriculumDto updateCuriculum(int id, CuriculumDto newCuriculum) {
        Curiculum baseCuriculum = academicConverter.toEntity(newCuriculum);
        Curiculum duplicate = curiculumRespository.findById(id);
        if (duplicate != null) {
            baseCuriculum.setId(id);
            baseCuriculum.setCreatedAt(duplicate.getCreatedAt());
            Curiculum createCuriculum = curiculumRespository.save(baseCuriculum);
            return academicConverter.toDto(createCuriculum);
        }
        return academicConverter.toDto(baseCuriculum);
    }
}
