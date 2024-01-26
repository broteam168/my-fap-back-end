package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Repository.Unit.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService implements ISchoolService{
    private final SchoolRepository schoolRepository;
    private final UnitConverter unitConverter;

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
}
