package broteam.myfap.backend.Converter.User.Student;


import broteam.myfap.backend.Dto.User.Student.StudentDto;
import broteam.myfap.backend.Dto.User.Student.StudentDtoRequest;
import broteam.myfap.backend.Models.User.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    public StudentDto toDto(Student entity){
        StudentDto dto = new StudentDto();
        if(entity.getUserId() > 0 ){
            dto.setUserId(entity.getUserId());
        }
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setMajor(entity.getMajor());
        dto.setSemester(entity.getSemester());
        dto.setSchorlarship(entity.getSchorlarship());
        dto.setSchoolId(entity.getSchoolId());
        return dto;
    }

    public Student toEntity(StudentDto dto){
        Student entity = new Student();
        entity.setUserId(dto.getUserId());
        entity.setMajor(dto.getMajor());
        entity.setSemester(dto.getSemester());
        entity.setSchorlarship(dto.getSchorlarship());
        entity.setSchoolId(dto.getSchoolId());
        return entity;
    }

    public Student toEntity(StudentDtoRequest dto){
        Student entity = new Student();
        entity.setUserId(dto.getUserId());
        entity.setMajor(dto.getMajor());
        entity.setSemester(dto.getSemester());
        entity.setSchorlarship(dto.getSchorlarship());
        entity.setSchoolId(dto.getSchoolId());
        return entity;
    }
}
