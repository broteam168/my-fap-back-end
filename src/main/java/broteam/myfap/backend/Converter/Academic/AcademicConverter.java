package broteam.myfap.backend.Converter.Academic;

import broteam.myfap.backend.Dto.Academic.SemesterDto;
import broteam.myfap.backend.Dto.Academic.SemesterRequestDto;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorRequestDto;
import broteam.myfap.backend.Models.Academic.Semester;
import broteam.myfap.backend.Models.Major.Major;
import broteam.myfap.backend.Models.Major.SubMajor;
import org.springframework.stereotype.Component;

@Component
public class AcademicConverter {
    public SemesterDto toDto(Semester entity){
        SemesterDto dto = new SemesterDto();
        if(entity.getId() > 0 ){
            dto.setId(entity.getId());
        }
        dto.setId(entity.getId());
        dto.setName(entity.getName());
         dto.setDescription(entity.getDescription());
        dto.setYear(entity.getYear());
        dto.setOrder(entity.getOrder());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setIsActive(entity.isIsActive());
        return dto;
    }
    public SemesterRequestDto toDtoRequest(Semester entity){
        SemesterRequestDto dto = new SemesterRequestDto();

        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setYear(entity.getYear());
        dto.setOrder(entity.getOrder());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setIsActive(entity.isIsActive());
        return dto;
    }
}
