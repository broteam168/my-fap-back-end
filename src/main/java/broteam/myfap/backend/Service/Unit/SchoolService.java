package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Repository.Unit.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SchoolService implements ISchoolService{
    private final SchoolRepository schoolRepository;
    private final UnitConverter unitConverter;
    private ModelMapper modelMapper = new ModelMapper();

    public SchoolService(SchoolRepository schoolRepository, UnitConverter unitConverter) {
        this.schoolRepository = schoolRepository;
        this.unitConverter = unitConverter;
    }

    @Override
    public List<SchoolDto> findAllBase() {
        List<SchoolDto> results = new ArrayList<>();
        for(School school :  schoolRepository.findAll())
        {
            results.add(unitConverter.toDto(school));
        };
        return  results;
    }

    @Transactional
    @Override
   public void createNewSchool(SchoolDto newSchool) {
        School baseSchool = modelMapper.map(newSchool, School.class);

        Optional<School> duplicate = schoolRepository.findByName(baseSchool.getName());
        System.out.println(duplicate.stream().count());
     /*   if (!baseSchool.getName() ||
      */  /*    baseSchool.getName().equals("")
        ||)
        {}*/
     /*   School createdSchool = schoolRepository.save(baseSchool);
*/
    }
}
