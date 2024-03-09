package broteam.myfap.backend.Service.Academic.Implementation;

import broteam.myfap.backend.Converter.Academic.StudentConverter;
import broteam.myfap.backend.Dto.Academic.StudentDto;
import broteam.myfap.backend.Dto.Academic.StudentRequest;
import broteam.myfap.backend.Exception.NotFoundException;
import broteam.myfap.backend.Models.Academic.Student;
import broteam.myfap.backend.Models.Academic.Subject;
import broteam.myfap.backend.Repository.Academic.StudentResponsitory;
import broteam.myfap.backend.Service.Academic.Interface.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentResponsitory studentResponsitory;
    private final StudentConverter studentConverter;

    @Override
    public List<StudentDto> findAllBase() {
        List<StudentDto> results = new ArrayList<>();
        for (Student student : studentResponsitory.findAll()) {
            results.add(studentConverter.toDto(student));
        }
        return results;
    }

    @Override
    public StudentRequest findStudentById(int id) {
        Student gotStudent = studentResponsitory.findById(id);
        if (gotStudent == null) {
            throw new NotFoundException("Cannot find student");
        }
        return studentConverter.toRequestDto(gotStudent);
    }

    @Override
    public StudentDto findStudentByUserId(int id) {
        Student gotStudent = studentResponsitory.findByUserId(id);
        if (gotStudent == null) {
            throw new NotFoundException("Cannot find student");
        }
        return studentConverter.toDto(gotStudent);
    }

}
