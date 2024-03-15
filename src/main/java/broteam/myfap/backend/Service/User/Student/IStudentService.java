package broteam.myfap.backend.Service.User.Student;

import broteam.myfap.backend.Dto.User.Student.StudentDto;
import broteam.myfap.backend.Dto.User.Student.StudentDtoRequest;
import broteam.myfap.backend.Models.User.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IStudentService {
    List<StudentDto> getAllStudent(int size, int page);

    Student getDetailStudent(int userId);

    long countStudent();

    List<StudentDto> fillAllB();

    StudentDto createStudent(StudentDtoRequest studentDto);

    StudentDto updateStudent(int StudentId, StudentDtoRequest StudentDto);

    @Transactional
    void deleteStudentById(int customerId);
}
