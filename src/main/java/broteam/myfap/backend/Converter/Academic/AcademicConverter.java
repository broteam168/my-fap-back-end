package broteam.myfap.backend.Converter.Academic;

import broteam.myfap.backend.Dto.Academic.SubjectDto;
import broteam.myfap.backend.Models.Academic.Subject;
import org.springframework.stereotype.Component;

@Component
public class AcademicConverter {
    public SubjectDto toDto(Subject entity) {
        SubjectDto dto = new SubjectDto();
        if (entity.getId() > 0) {
            dto.setId(entity.getId());
        }
        dto.setName(entity.getName());
        dto.setSubjectCode(entity.getSubjectCode());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setMinAvgMarkToPass(entity.getMinAvgMarkToPass());
        dto.setDescription(entity.getDescription());
        dto.setCredits(entity.getCredits());
        dto.setPrerequisite(entity.getPrerequisite());

        return dto;
    }

    public Subject toEntity(SubjectDto dto) {
        Subject entity = new Subject();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSubjectCode(dto.getSubjectCode());
        entity.setType(dto.getType());
        entity.setStatus(dto.getStatus());
        entity.setMinAvgMarkToPass(dto.getMinAvgMarkToPass());
        entity.setDescription(dto.getDescription());
        entity.setCredits(dto.getCredits());
        entity.setPrerequisite(dto.getPrerequisite());

        return entity;
    }
}
