package broteam.myfap.backend.Controllers.Unit;

import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Service.Unit.ClassService;
import broteam.myfap.backend.Service.Unit.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unit/class")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClassController {
    private final ClassService classService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllClass() {
        List<ClassDto> allClasses = classService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allClasses)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
}
