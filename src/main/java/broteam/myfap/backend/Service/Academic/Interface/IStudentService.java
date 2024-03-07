package broteam.myfap.backend.Service.Academic.Interface;

import broteam.myfap.backend.Dto.Academic.StudentDto;
import broteam.myfap.backend.Dto.Academic.StudentRequest;
import broteam.myfap.backend.Models.Academic.Subject;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IStudentService {

    List<StudentDto> findAllBase();

    @Transactional
    StudentRequest findStudentById(int id);
}
