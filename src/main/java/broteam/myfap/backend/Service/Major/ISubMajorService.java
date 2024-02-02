package broteam.myfap.backend.Service.Major;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.MajorRequestDto;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorRequestDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISubMajorService {
    List<SubMajorDto> findAllBase();


    @Transactional
    SubMajorDto createNewSubMajor(SubMajorRequestDto newSubMajor);
}
