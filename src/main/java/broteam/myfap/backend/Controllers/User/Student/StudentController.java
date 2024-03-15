package broteam.myfap.backend.Controllers.User.Student;

import broteam.myfap.backend.Controllers.BaseController;
import broteam.myfap.backend.Dto.PagedResponseObject;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.User.Student.StudentDto;
import broteam.myfap.backend.Dto.User.Student.StudentDtoRequest;
import broteam.myfap.backend.Models.User.Student;
import broteam.myfap.backend.Service.User.Student.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController extends BaseController {
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllStudent() {
        List<StudentDto> newStudent = studentService.fillAllB();
        return ResponseEntity.ok(ResponseObject.builder().data(newStudent).message("Get successful").responseCode(HttpStatus.OK.value()).build());
    }

    //lấy danh sách student
    @GetMapping("page")
    public ResponseEntity<PagedResponseObject> getPagedUser(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        long totalItems = studentService.countStudent();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        List<StudentDto> users = studentService.getAllStudent(page, size);
        return ResponseEntity.ok(PagedResponseObject.builder().page(page).perPage(size).totalItems(totalItems).totalPages(totalPages).responseCode(200).message("Success").data(users).build());
    }

    //lấy chi tiết student theo id
    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getDetailUser(@PathVariable("id") int userId) {
        Student student = studentService.getDetailStudent(userId);
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(student).build());
    }

    //lấy số lượng student
    @GetMapping("count")
    public ResponseEntity<ResponseObject> getCountUser() {
        long countUser = studentService.countStudent();
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(countUser).build());
    }

    //tạo student
    @PostMapping
    public ResponseEntity<ResponseObject> createCustomer(@Valid @RequestBody StudentDtoRequest student) {
        StudentDto newStudent = null;
        try {
            newStudent = studentService.createStudent(student);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(ResponseObject.builder().responseCode(202).message(e.getMessage()).data(null).build());
        }
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(newStudent).build());


    }

    //sửa student
    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateCustomer(@PathVariable("id") int customerId, @RequestBody StudentDtoRequest user) {
        StudentDto newCustomer = studentService.updateStudent(customerId, user);
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(newCustomer).build());
    }

    //xóa student
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseObject> deleteCustomer(@PathVariable("id") int userId) {
        studentService.deleteStudentById(userId);
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Deleted Customer").data(null).build());
    }
}
