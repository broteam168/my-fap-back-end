package broteam.myfap.backend.Service.Major;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;

import java.util.List;

public interface IMajorService {
    List<MajorDto> findAllBase();

}
