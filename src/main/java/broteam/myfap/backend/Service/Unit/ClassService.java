package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.ClassRequest;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Unit.Class;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Repository.Unit.ClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService {
    private final ClassRepository classRepository;
    private final UnitConverter unitConverter;

    private final SchoolService schoolService;
    private final ModelMapper modelMapper = new ModelMapper();

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
    @Transactional
    @Override
    public ClassDto createNewCLass(ClassRequest newCLass) {
        Class baseClass = modelMapper.map(newCLass, Class.class);

        Optional<Class> duplicate = classRepository.findByName(baseClass.getName());
        if(duplicate.stream().count()>0)
        {
            throw new SchoolException("Class name is already used");
        }
        Class createdClass = classRepository.save(baseClass);
        return unitConverter.toDto(createdClass);
    }
}
