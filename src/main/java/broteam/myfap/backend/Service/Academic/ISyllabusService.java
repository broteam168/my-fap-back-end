package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Dto.Academic.SyllabusDto;
import broteam.myfap.backend.Dto.Academic.SyllabusRequest;
import broteam.myfap.backend.Models.Academic.Syllabus;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ISyllabusService {
    List<SyllabusDto> findAllBase();

    SyllabusDto findSyllabusById(int id);

    List<SyllabusDto> findBySubjectId(int id);

    @Transactional
    SyllabusDto createNewSyllabus(SyllabusDto newSyllabus);

    @Transactional
    SyllabusDto updateSyllabusById(int id, SyllabusRequest newSyllabus);

    @Transactional
    SyllabusDto deleteSyllabusById(int id);
}
