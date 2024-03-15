package broteam.myfap.backend.Service.User.Teacher;

import broteam.myfap.backend.Dto.User.Teacher.TeacherDto;
import broteam.myfap.backend.Dto.User.Teacher.TeacherDtoRequest;
import broteam.myfap.backend.Models.User.Teacher;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITeacherService {
    List<TeacherDto> getAllTeacher(int size, int page);

    Teacher getDetailTeacher(int id);

    long countTeacher();

    List<TeacherDto> fillAllB();

    TeacherDto createTeacher(TeacherDtoRequest teacherDtoRequest);

    TeacherDto updateTeacher(int id, TeacherDtoRequest teacherDto);

    @Transactional
    void deleteTeacherById(int customerId);
}
