package broteam.myfap.backend.Controllers.User.Teacher;

import broteam.myfap.backend.Controllers.BaseController;
import broteam.myfap.backend.Dto.PagedResponseObject;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.User.Teacher.TeacherDto;
import broteam.myfap.backend.Dto.User.Teacher.TeacherDtoRequest;
import broteam.myfap.backend.Models.User.Teacher;
import broteam.myfap.backend.Service.User.Teacher.ITeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController extends BaseController {
    private final ITeacherService teacherService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllTeacher() {
        List<TeacherDto> newTeacher = teacherService.fillAllB();
        return ResponseEntity.ok(ResponseObject.builder().data(newTeacher).message("Get successful").responseCode(HttpStatus.OK.value()).build());
    }

    //lấy danh sách teacher
    @GetMapping("page")
    public ResponseEntity<PagedResponseObject> getPagedUser(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        long totalItems = teacherService.countTeacher();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        List<TeacherDto> users = teacherService.getAllTeacher(page, size);
        return ResponseEntity.ok(PagedResponseObject.builder().page(page).perPage(size).totalItems(totalItems).totalPages(totalPages).responseCode(200).message("Success").data(users).build());
    }

    //lấy chi tiết teacher theo id
    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getDetailUser(@PathVariable("id") int id) {
        Teacher teacher = teacherService.getDetailTeacher(id);
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(teacher).build());
    }

    //lấy số lượng teacher
    @GetMapping("count")
    public ResponseEntity<ResponseObject> getCountUser() {
        long countTeacher = teacherService.countTeacher();
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(countTeacher).build());
    }

    //tạo teacher
    @PostMapping
    public ResponseEntity<ResponseObject> createCustomer(@Valid @RequestBody TeacherDtoRequest teacher) {
        TeacherDto newTeacher = null;
        try {
            newTeacher = teacherService.createTeacher(teacher);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(ResponseObject.builder().responseCode(202).message(e.getMessage()).data(null).build());
        }
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(newTeacher).build());


    }

    //sửa teacher
    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateCustomer(@PathVariable("id") int id, @RequestBody TeacherDtoRequest teacherDtoRequest) {
        TeacherDto newTeacher = teacherService.updateTeacher(id, teacherDtoRequest);
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Success").data(newTeacher).build());
    }

    //xóa teacher
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseObject> deleteCustomer(@PathVariable("id") int id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok(ResponseObject.builder().responseCode(200).message("Deleted Customer").data(null).build());
    }
}
