package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Converter.Academic.AcademicConverter;
import broteam.myfap.backend.Dto.Academic.SyllabusDto;
import broteam.myfap.backend.Dto.Academic.SyllabusRequest;
import broteam.myfap.backend.Exception.NotFoundException;
import broteam.myfap.backend.Models.Academic.Subject;
import broteam.myfap.backend.Models.Academic.Syllabus;
import broteam.myfap.backend.Repository.Academic.SyllabusRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SyllabusService implements ISyllabusService{
    private final SyllabusRespository syllabusRespository;
    private final AcademicConverter academicConverter;
    private final SubjectService subjectService;

    @Override
    public List<SyllabusDto> findAllBase() {
        List<SyllabusDto> results = new ArrayList<>();
        for (Syllabus syllabus : syllabusRespository.findAll()) {
            results.add(academicConverter.toDto(syllabus));
        }
        return results;
    }

    @Override
    public SyllabusDto findSyllabusById(int id) {
        Syllabus gotSyllabus = syllabusRespository.findById(id);
        if (gotSyllabus == null)
            throw new NotFoundException("Cannot find syllabus");
        return academicConverter.toDto(gotSyllabus);

    }

    @Override
    public List<SyllabusDto> findBySubjectId(int id) {
        List<SyllabusDto> results = new ArrayList<>();

        Subject curruntSubject = new Subject();
        try {
            curruntSubject = subjectService.findSubjectById(id);
        } catch (Exception e) {
            return results;
        }

        List<Syllabus> syllabuses = curruntSubject.getSyllabuses();
        for (Syllabus item : syllabuses) {
            results.add(academicConverter.toDto(item));
        }

        return results;
    }

    @Override
    public SyllabusDto createNewSyllabus(SyllabusDto newSyllabus) {
        return null;
    }

    @Override
    public SyllabusDto updateSyllabusById(int id, SyllabusRequest newSyllabus) {
        return null;
    }

    @Override
    public SyllabusDto deleteSyllabusById(int id) {
        return null;
    }
}
