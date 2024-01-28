package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Models.Unit.Class;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Repository.Unit.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService implements IClassService {
    private final ClassRepository classRepository;
    private final UnitConverter unitConverter;

    private final SchoolService schoolService;

    public ClassService(ClassRepository classRepository, UnitConverter unitConverter, SchoolService schoolService) {
        this.classRepository = classRepository;
        this.unitConverter = unitConverter;
        this.schoolService = schoolService;
    }
    @Override
    public List<ClassDto> findAllBase() {

        List<ClassDto> results = new ArrayList<>();
        for(Class classItem:classRepository.findAll())
        {
               results.add(unitConverter.toDto(classItem));
        }
        return  results;
    }

    @Override
    public List<ClassDto> FindBySchoolId(int id) {
        List<ClassDto> results = new ArrayList<>();
        School currentSchool= new School();
        try {
            currentSchool = schoolService.findSchoolById(id);
        } catch (Exception ex) {
            return results;
        }
            List<Class> result =  currentSchool.getClasses();
            for(Class item:result)
            {
                results.add(unitConverter.toDto(item));
            }

        return results;
    }
}
