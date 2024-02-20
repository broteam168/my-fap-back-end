package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Dto.Academic.SemesterDto;
import broteam.myfap.backend.Dto.Academic.SemesterRequestDto;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.MajorRequestDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISemesterService {

    List<SemesterDto> findAllBase();

    @Transactional
    SemesterDto createNewSemester(SemesterRequestDto newMajor);

    SemesterDto findById(int id);
}
