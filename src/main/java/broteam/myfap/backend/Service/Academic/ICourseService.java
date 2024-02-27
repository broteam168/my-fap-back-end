package broteam.myfap.backend.Service.Academic;

import broteam.myfap.backend.Dto.Academic.*;

import java.util.List;

public interface ICourseService {

    List<CourseDto> findAllBase();

    List<ReturnCourseDto> addCoursesByClasses(CourseRequest1Dto newData);
}
