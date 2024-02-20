package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Converter.Academic.AcademicConverter;
import broteam.myfap.backend.Dto.Academic.SemesterDto;
import broteam.myfap.backend.Dto.Academic.SemesterRequestDto;
import broteam.myfap.backend.Exception.NotFoundException;
import broteam.myfap.backend.Models.Academic.Semester;
import broteam.myfap.backend.Repository.Academic.SemesterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SemesterService implements ISemesterService {
    private final SemesterRepository semesterRepository;

    private final AcademicConverter academicConverter;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<SemesterDto> findAllBase() {
        List<SemesterDto> results = new ArrayList<>();
        for(Semester semester :  semesterRepository.findAll())
        {

            results.add(academicConverter.toDto(semester));
        }
        return  results;
    }

    @Transactional
    @Override
    public SemesterDto createNewSemester(SemesterRequestDto newMajor) {

        Semester base = modelMapper.map(newMajor, Semester.class);

         Semester createdMajor = semesterRepository.save(base);

        return academicConverter.toDto(createdMajor);
    }
    @Override
    public SemesterDto findById(int id) {
        Optional<Semester> gotSemester = semesterRepository.findById(id);
        if(gotSemester.isEmpty() ) throw new NotFoundException("Cannot find semester");
        return academicConverter.toDto(gotSemester.get());
    }
}
