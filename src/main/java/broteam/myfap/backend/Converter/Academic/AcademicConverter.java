package broteam.myfap.backend.Converter.Academic;


import broteam.myfap.backend.Dto.Academic.SemesterDto;
import broteam.myfap.backend.Dto.Academic.SemesterRequestDto;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorRequestDto;
import broteam.myfap.backend.Models.Academic.Semester;
import broteam.myfap.backend.Models.Major.Major;
import broteam.myfap.backend.Models.Major.SubMajor;

import broteam.myfap.backend.Dto.Academic.CuriculumDto;
import broteam.myfap.backend.Dto.Academic.SubjectDto;
import broteam.myfap.backend.Dto.Academic.SyllabusDto;
import broteam.myfap.backend.Models.Academic.Curiculum;
import broteam.myfap.backend.Models.Academic.Subject;
import broteam.myfap.backend.Models.Academic.Syllabus;

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

    public SubjectDto toDto(Subject entity) {
        SubjectDto dto = new SubjectDto();
        if (entity.getId() > 0) {
            dto.setId(entity.getId());
        }
        dto.setName(entity.getName());
        dto.setSubjectCode(entity.getSubjectCode());
        dto.setType(entity.getType());
        dto.setStatus(entity.isStatus());
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
        entity.setStatus(dto.isStatus());
        entity.setDescription(dto.getDescription());
        entity.setCredits(dto.getCredits());
        entity.setPrerequisite(dto.getPrerequisite());
        return entity;
    }

    public SyllabusDto toDto(Syllabus entity) {
        SyllabusDto dto = new SyllabusDto();
        if (entity.getId() > 0) {
            dto.setId(entity.getId());
        }
        dto.setStudentTasks(entity.getStudentTasks());
        dto.setTools(entity.getTools());
        dto.setScoringScale(entity.getScoringScale());
        dto.setMarkMin(entity.getMarkMin());
        dto.setApprovedDate(entity.getApprovedDate());
        dto.setSlot(entity.getSlot());
        dto.setSubjectId(entity.getSubjectId());
        dto.setActive(entity.isActive());
        return dto;
    }

    public Syllabus toEntity(SyllabusDto dto) {
        Syllabus entity = new Syllabus();
        if (dto.getId() > 0) {
            entity.setId(dto.getId());
        }
        entity.setStudentTasks(dto.getStudentTasks());
        entity.setTools(dto.getTools());
        entity.setScoringScale(dto.getScoringScale());
        entity.setMarkMin(dto.getMarkMin());
        entity.setApprovedDate(dto.getApprovedDate());
        entity.setSlot(dto.getSlot());
        entity.setSubjectId(dto.getSubjectId());
        entity.setActive((dto.isActive()));
        return entity;
    }



    public CuriculumDto toDto(Curiculum entity) {
        CuriculumDto dto = new CuriculumDto();
        if (entity.getId() > 0) {
            dto.setId(entity.getId());
        }
        dto.setSubject(entity.getSubject());
        dto.setSubMajorId(entity.getSubMajorId());
        dto.setSemester(entity.getSemester());
        dto.setCreateAt(entity.getCreatedAt());
        return dto;
    }

    public Curiculum toEntity(CuriculumDto dto) {
        Curiculum entity = new Curiculum();
        if (dto.getId() > 0) {
            entity.setId(dto.getId());
        }
        entity.setSubject(dto.getSubject());
        entity.setSubMajorId(dto.getSubMajorId());
        entity.setSemester(dto.getSemester());
        entity.setCreatedAt(dto.getCreateAt());

        return entity;
    }

}
