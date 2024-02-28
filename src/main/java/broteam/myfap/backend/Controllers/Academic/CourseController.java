package broteam.myfap.backend.Controllers.Academic;

import broteam.myfap.backend.Dto.Academic.CourseDto;
import broteam.myfap.backend.Dto.Academic.CourseRequest1Dto;
import broteam.myfap.backend.Dto.Academic.ReturnCourseDto;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Service.Academic.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/academic/course")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
    private final ICourseService courseService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllBase() {
        List<CourseDto> allSemester = courseService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder().data(allSemester).message("Get successful").responseCode(HttpStatus.OK.value()).build());
    }

    @PostMapping
    public ResponseEntity<ResponseObject> createCourse(@Valid @RequestBody CourseRequest1Dto newCourse) {
        String returnMessage = "Create successfully";
        int responseCode = HttpStatus.OK.value();
        List<ReturnCourseDto> returnCourses = new ArrayList<>();
        try {
            returnCourses = courseService.addCoursesByClasses(newCourse);
        } catch (Exception e) {
            returnMessage = e.getMessage();
            responseCode = HttpStatus.ACCEPTED.value();
        }

        return ResponseEntity.ok(ResponseObject.builder().data(returnCourses).message(returnMessage).responseCode(responseCode).build());
    }

    @GetMapping("search")
    public ResponseEntity<ResponseObject> getAllBase(@RequestParam(name = "schoolid") Optional<Integer> schoolId, @RequestParam(name = "classid") Optional<Integer> classId) {
        List<CourseDto> allSemester = new ArrayList<>();
        allSemester = courseService.findBySchoolAndClass(schoolId, classId);
        return ResponseEntity.ok(ResponseObject.builder().data(allSemester).message("Get successful").responseCode(HttpStatus.OK.value()).build());
    }
}
