package broteam.myfap.backend.Service.Unit;

import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.ClassRequest;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClassService {
    List<ClassDto> findAllBase();


    List<ClassDto> FindBySchoolId(int id);

    @Transactional
    ClassDto createNewCLass(ClassRequest newCLass);

    @Transactional
    ClassDto updateClass(int id, ClassRequest newCLass);
}
