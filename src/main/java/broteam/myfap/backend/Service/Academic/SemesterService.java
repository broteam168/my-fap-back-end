package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Converter.Academic.AcademicConverter;
import broteam.myfap.backend.Dto.Academic.SemesterDto;
import broteam.myfap.backend.Models.Academic.Semester;
import broteam.myfap.backend.Repository.Academic.SemesterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


}
