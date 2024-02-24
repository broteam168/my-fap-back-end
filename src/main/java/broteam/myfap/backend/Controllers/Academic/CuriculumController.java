package broteam.myfap.backend.Controllers.Academic;

import broteam.myfap.backend.Dto.Academic.CuriculumDto;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Service.Academic.CuriculumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/academic/curiculum")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CuriculumController {
    private final CuriculumService curiculumService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllCuriculum() {
        List<CuriculumDto> allCuriculum = curiculumService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allCuriculum)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getCuriculumById(@Valid @PathVariable int id) {
        String returnMessage = "Get Successfully";
        int responseCode = HttpStatus.OK.value();
        CuriculumDto returnCuriculum = new CuriculumDto();
        try {
            returnCuriculum = curiculumService.findCuriculumById(id);
        } catch (Exception e) {
            returnMessage = e.getMessage();
            responseCode = HttpStatus.ACCEPTED.value();
        }
        return ResponseEntity.ok(ResponseObject.builder()
                .data(returnCuriculum)
                .message(returnMessage)
                .responseCode(responseCode)
                .build());
    }

    @PostMapping
    public ResponseEntity<ResponseObject> createCuriculum(@Valid @RequestBody CuriculumDto newCuriculum) {
        String returnMessage = "Create successfully";
        int responseCode = HttpStatus.OK.value();
        CuriculumDto returnCuriculum = new CuriculumDto();
        try {
            returnCuriculum = curiculumService.createNewCuriculum(newCuriculum);
        } catch (Exception e) {
            returnMessage = e.getMessage();
            responseCode = HttpStatus.ACCEPTED.value();
        }

        return ResponseEntity.ok(ResponseObject.builder()
                .data(returnCuriculum)
                .message(returnMessage)
                .responseCode(responseCode)
                .build());
    }


}
