package broteam.myfap.backend.Converter.Major;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.Major;
import broteam.myfap.backend.Models.Unit.School;
import org.springframework.stereotype.Component;

@Component
public class MajorConverter {
    public MajorDto toDto(Major entity){
        MajorDto dto = new MajorDto();
        if(entity.getId() > 0 ){
            dto.setId(entity.getId());
        }
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setFullName(entity.getFullName());
        dto.setDescription(entity.getDescription());
        dto.setDegreeLevel(entity.getDegreeLevel());
        dto.setCategory(entity.getCategory());
        dto.setIsActive(entity.isIsActive());
        return dto;
    }
}
