package broteam.myfap.backend.Service.User.Student;

import broteam.myfap.backend.Converter.User.Student.StudentConverter;
import broteam.myfap.backend.Dto.User.Student.StudentDto;
import broteam.myfap.backend.Dto.User.Student.StudentDtoRequest;
import broteam.myfap.backend.Exception.User.StudentException;
import broteam.myfap.backend.Models.User.Student;
import broteam.myfap.backend.Repository.User.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    @Override
    public List<StudentDto> getAllStudent(int size, int page) {
        int offset = (page - 1) * size;
        List<StudentDto> results = new ArrayList<>();
        for (Student studentList : studentRepository.findAllStudent(size, offset)) {
            results.add(studentConverter.toDto(studentList));
        }
        return results;
    }

    @Override
    public Student getDetailStudent(int userId) {
        try {
            return studentRepository.findById(userId).orElseThrow(() -> new BadRequestException("Không tìm thấy Student với ID: " + userId));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long countStudent() {
        return studentRepository.count();
    }

    @Override
    public List<StudentDto> fillAllB() {
        List<StudentDto> results = new ArrayList<>();
        for (Student school : studentRepository.findAll()) {
            results.add(studentConverter.toDto(school));
        }
        return results;
    }

    @Override
    public StudentDto createStudent(StudentDtoRequest studentDto) {
        Optional<Student> existingStudent = studentRepository.findById(studentDto.getUserId());
        if (existingStudent.isPresent()) {
            throw new StudentException("Student đã tồn tại trong hệ thống.");
        }
        Student newStudent = studentConverter.toEntity(studentDto);
        Student savedStudent = studentRepository.save(newStudent);
        studentRepository.setRoleStudent(studentDto.getUserId());
        return studentConverter.toDto(savedStudent);
    }


    @Override
    public StudentDto updateStudent(int userId, StudentDtoRequest userDto) {
        Student existingUser = studentRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            throw new StudentException("Student không tồn tại.");
        }
        existingUser.setMajor(userDto.getMajor());
        existingUser.setSemester(userDto.getSemester());
        existingUser.setSchorlarship(userDto.getSchorlarship());
        existingUser.setSchoolId(userDto.getSchoolId());
        studentRepository.save(existingUser);
        return studentConverter.toDto(existingUser);
    }

    @Override
    @Transactional
    public void deleteStudentById(int userId) {
        boolean exists = studentRepository.existsById(userId);

        if (exists) {
            studentRepository.removeUserRole(userId);
            studentRepository.deleteById(userId);
        } else {
            throw new StudentException("Không tìm thấy Student với ID: " + userId);
        }
    }

}
