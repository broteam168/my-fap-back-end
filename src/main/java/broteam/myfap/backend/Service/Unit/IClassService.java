package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;

import java.util.List;

public interface IClassService {
    List<ClassDto> findAllBase();

}
