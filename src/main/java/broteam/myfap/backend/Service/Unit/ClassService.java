package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.Class;
import broteam.myfap.backend.Repository.Unit.ClassRepository;
import broteam.myfap.backend.Repository.Unit.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService implements IClassService {
    private final ClassRepository classRepository;
    private final UnitConverter unitConverter;

    public ClassService(ClassRepository classRepository,UnitConverter unitConverter) {
        this.classRepository = classRepository;
        this.unitConverter = unitConverter;
    }
    @Override
    public List<ClassDto> findAllBase() {

        List<ClassDto> results = new ArrayList<>();
        for(Class classItem:classRepository.findAll())
        {
            results.add(unitConverter.toDto(classItem));
        };
        return  results;
    }
}
