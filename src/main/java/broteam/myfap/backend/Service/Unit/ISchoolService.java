package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.School;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISchoolService {
     List<SchoolDto> findAllBase();
     SchoolDto createNewSchool(SchoolDto newSchool);

     School findSchoolById(int id);


     @Transactional
     SchoolDto updateSchool(SchoolDto newSchool);
}
