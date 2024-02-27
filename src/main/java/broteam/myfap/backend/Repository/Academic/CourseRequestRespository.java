package broteam.myfap.backend.Repository.Academic;

import broteam.myfap.backend.Models.Academic.Course;
import broteam.myfap.backend.Models.Academic.RequestCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRequestRespository extends JpaRepository<RequestCourse, Integer> {


}
