package broteam.myfap.backend.Converter.Unit;

import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.School;
import org.springframework.stereotype.Component;

@Component
public class SchoolConverter {
    public SchoolDto toDto(School entity){
        SchoolDto dto = new SchoolDto();
        if(entity.getId() > 0 ){
            dto.setId(entity.getId());
        }
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setLocation(entity.getLocation());
        dto.setPhone(entity.getPhone());
        dto.setIsActive(entity.isIsActive());

        return dto;
    }
}
