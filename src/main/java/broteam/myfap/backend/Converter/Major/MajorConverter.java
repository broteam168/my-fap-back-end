package broteam.myfap.backend.Converter.Major;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.Major;
import broteam.myfap.backend.Models.Unit.School;

public class MajorConverter {
    public MajorDto toDto(Major entity){
        MajorDto dto = new MajorDto();
        if(entity.getId() > 0 ){
            dto.(entity.getId());
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
