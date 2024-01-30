package broteam.myfap.backend.Controllers.Academic;

import broteam.myfap.backend.Converter.Academic.AcademicConverter;
import broteam.myfap.backend.Dto.Academic.SubjectDto;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Exception.Academic.SubjectException;
import broteam.myfap.backend.Service.Academic.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unit/subject")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {
    private final SubjectService subjectService;
    private final AcademicConverter academicConverter;
    @GetMapping
    public ResponseEntity<ResponseObject> GetAllScholls() {
        List<SubjectDto> allSubjects = subjectService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allSubjects)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());

    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> GetDetailedSubject(@PathVariable @Valid String id) {
        String returnMessage = "Create Successfully";
        int responseCode = HttpStatus.OK.value();
        SubjectDto returnSubject = new SubjectDto();
        try {
            returnSubject = academicConverter.toDto(subjectService.findSubjectById(Integer.parseInt(id)));
        } catch (Exception e) {
            returnMessage = e.getMessage();
            responseCode = HttpStatus.ACCEPTED.value();
        }

        return ResponseEntity.ok(ResponseObject.builder()
                .data(returnSubject)
                .message(returnMessage)
                .responseCode(responseCode)
                .build());
    }

    @PostMapping
    public ResponseEntity<ResponseObject> CreateSubject(@Valid @RequestBody SubjectDto newSubject) {
        String returnMessage = "Create Successfully";
        int responseCode = HttpStatus.OK.value();
        SubjectDto returnSubject = new SubjectDto();
        try {
            returnSubject = subjectService.createNewSubject(newSubject);
        } catch (SubjectException e) {
            returnMessage = e.getMessage();
            responseCode = HttpStatus.ACCEPTED.value();
        } catch (Exception e2) {
            returnMessage = "Some error occus";
            responseCode = HttpStatus.ACCEPTED.value();
        }

        return ResponseEntity.ok(ResponseObject.builder()
                .data(returnSubject)
                .message(returnMessage)
                .responseCode(responseCode)
                .build());
    }

//    @PutMapping("{id}")
//    public ResponseEntity<ResponseObject> CreateSubject
}
