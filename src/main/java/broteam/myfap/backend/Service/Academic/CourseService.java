package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Converter.Academic.AcademicConverter;
import broteam.myfap.backend.Dto.Academic.*;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Models.Academic.Course;
import broteam.myfap.backend.Models.Academic.RequestCourse;
import broteam.myfap.backend.Repository.Academic.CourseRequestRespository;
import broteam.myfap.backend.Repository.Academic.CourseRespository;
import broteam.myfap.backend.Service.Major.SubMajorService;
import broteam.myfap.backend.Service.Unit.ClassService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService{
    private final CourseRespository courseRespository;
    private final CourseRequestRespository courseRequestRespository;

    private final AcademicConverter academicConverter;
    private final ClassService classService;
    private final SemesterService semesterService;
    private final SubMajorService subMajorService;
    private final CuriculumService curiculumService;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<CourseDto> findAllBase() {
        List<CourseDto> results = new ArrayList<>();
        for (Course course : courseRespository.findAll()) {
            results.add(modelMapper.map(course,CourseDto.class));
        }
        return results;
    }

    @Transactional
    @Override
    public List<ReturnCourseDto> addCoursesByClasses(CourseRequest1Dto newData) {

        List<ReturnCourseDto> results = new ArrayList<>();

        ///Get current class
        ClassDto currentClass  = classService.findClassById(newData.getClassId());

        /// Get current semester
        SemesterDto currentSemester = semesterService.getCurrentSemester();
        System.out.println(currentSemester.getId());
        if(newData.getSemester() < 5)
        {
            List<SubjectDto> gotSubjects = new ArrayList<>();
            List<SubMajorDto> gotSub=subMajorService.FindByMajorId(currentClass.getMajor().getId());
            SubMajorDto common = gotSub.stream().filter(x->x.isIsCommon()).toList().get(0);
            List<CuriculumDto> curiculumDtos =  curiculumService.findCuriBySubMajorIdAndSememster(common.getId(),newData.getSemester());
            if(curiculumDtos.stream().count()==0) throw new RuntimeException("No subject in semester and major. Please create!");
            for (CuriculumDto dto : curiculumDtos)
            {
                   RequestCourse newCourse = new RequestCourse();
                   newCourse.setClassId(currentClass.getId());
                   newCourse.setName(currentClass.getName()+"_"+dto.getSubject().getSubjectCode());
                   newCourse.setStatus("DRAFT");
                   newCourse.setSemesterId(currentSemester.getId());
                   newCourse.setSubMajorId(common.getId());
                  newCourse.setSubjectId(dto.getSubject().getId());
                  newCourse.setRoomId(null);
                RequestCourse retur = courseRequestRespository.save(newCourse);
               if(retur!=null) results.add(modelMapper.map(retur,ReturnCourseDto.class));
            }
        }
        return results;
    }


}
