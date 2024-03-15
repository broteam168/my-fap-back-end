package broteam.myfap.backend.Service.User.Teacher;

import broteam.myfap.backend.Converter.User.Teacher.TeacherConverter;
import broteam.myfap.backend.Dto.User.Teacher.TeacherDto;
import broteam.myfap.backend.Dto.User.Teacher.TeacherDtoRequest;
import broteam.myfap.backend.Exception.User.TeacherException;
import broteam.myfap.backend.Models.User.Teacher;
import broteam.myfap.backend.Repository.User.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService implements ITeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherConverter teacherConverter;


    @Override
    public List<TeacherDto> getAllTeacher(int size, int page) {
        int offset = (page - 1) * size;
        List<TeacherDto> results = new ArrayList<>();
        for (Teacher teacherList : teacherRepository.findAllTeacher(size, offset)) {
            results.add(teacherConverter.toDto(teacherList));
        }
        return results;
    }

    @Override
    public Teacher getDetailTeacher(int userId) {
        // Sử dụng findById để user dựa trên id
        try {
            return teacherRepository.findById(userId).orElseThrow(() -> new BadRequestException("Không tìm thấy Teacher với ID: " + userId));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long countTeacher() {
        return teacherRepository.count();
    }

    @Override
    public List<TeacherDto> fillAllB() {
        List<TeacherDto> results = new ArrayList<>();
        for (Teacher school : teacherRepository.findAll()) {
            results.add(teacherConverter.toDto(school));
        }
        return results;
    }

    @Override
    public TeacherDto createTeacher(TeacherDtoRequest teacherDtoRequest) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(teacherDtoRequest.getUserId());
        if (existingTeacher.isPresent()) {
            throw new TeacherException("Teacher đã tồn tại trong hệ thống.");
        }
        Teacher newTeacher = teacherConverter.toEntity(teacherDtoRequest);
        Teacher savedTeacher = teacherRepository.save(newTeacher);
        teacherRepository.setRoleTeacher(teacherDtoRequest.getUserId());
        return teacherConverter.toDto(savedTeacher);
    }

    @Override
    public TeacherDto updateTeacher(int userId, TeacherDtoRequest userDto) {
        Teacher existingUser = teacherRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            throw new TeacherException("Teacher không tồn tại.");
        }
        existingUser.setSchoolId(userDto.getSchoolId());
        existingUser.setSalary(userDto.getSalary());
        existingUser.setCreatAt(userDto.getCreatAt());
        teacherRepository.save(existingUser);
        return teacherConverter.toDto(existingUser);
    }

    @Override
    @Transactional
    public void deleteTeacherById(int userId) {
        boolean exists = teacherRepository.existsById(userId);

        if (exists) {
            teacherRepository.removeUserRole(userId);
            teacherRepository.deleteById(userId);
        } else {
            throw new TeacherException("Không tìm thấy Teacher với ID: " + userId);
        }
    }
}
