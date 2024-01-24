package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.SchoolConverter;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Repository.Unit.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService implements ISchoolService{
    private final SchoolRepository schoolRepository;
    private final SchoolConverter schoolConverter;

    public SchoolService(SchoolRepository schoolRepository, SchoolConverter schoolConverter) {
        this.schoolRepository = schoolRepository;
        this.schoolConverter = schoolConverter;
    }

    @Override
    public List<SchoolDto> findAllBase() {
        List<SchoolDto> results = new ArrayList<>();
        for(School school :  schoolRepository.findAll())
        {
            results.add(schoolConverter.toDto(school));
        };
        return  results;
    }
}
