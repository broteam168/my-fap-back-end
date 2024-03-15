package broteam.myfap.backend.Converter.User.Teacher;

import broteam.myfap.backend.Dto.User.Teacher.TeacherDto;
import broteam.myfap.backend.Dto.User.Teacher.TeacherDtoRequest;
import broteam.myfap.backend.Models.User.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter {
    public TeacherDto toDto(Teacher entity){
        TeacherDto dto = new TeacherDto();
        if(entity.getUserId() > 0 ){
            dto.setUserId(entity.getUserId());
        }
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setSchoolId(entity.getSchoolId());
        dto.setSalary(entity.getSalary());
        dto.setCreatAt(entity.getCreatAt());
        return dto;
    }

    public Teacher toEntity(TeacherDto dto){
        Teacher entity = new Teacher();
        entity.setUserId(dto.getUserId());
        entity.setSchoolId(dto.getSchoolId());
        entity.setSalary(dto.getSalary());
        entity.setCreatAt(dto.getCreatAt());
        return entity;
    }

    public Teacher toEntity(TeacherDtoRequest dto){
        Teacher entity = new Teacher();
        entity.setUserId(dto.getUserId());
        entity.setSchoolId(dto.getSchoolId());
        entity.setSalary(dto.getSalary());
        entity.setCreatAt(dto.getCreatAt());
        return entity;
    }
}
