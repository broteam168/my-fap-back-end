package broteam.myfap.backend.Controllers.Time;

import broteam.myfap.backend.Dto.Academic.CourseDto;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.Time.SessionDto;
import broteam.myfap.backend.Dto.Time.SlotDto;
import broteam.myfap.backend.Dto.Time.SlotRequestDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Service.Time.ISessionService;
import broteam.myfap.backend.Service.Time.SlotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/time/session")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {
    private final ISessionService sessionService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllBase() {
        List<SessionDto> allGroup = sessionService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allGroup)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
    @GetMapping("search")
    public ResponseEntity<ResponseObject> getAllBase(@RequestParam(name = "schoolid") Optional<Integer> schoolId, @RequestParam(name = "classid") Optional<Integer> classId) {
        List<SessionDto> allsession = new ArrayList<>();
        allsession = sessionService.findBySchoolAndClass(schoolId, classId);
        return ResponseEntity.ok(ResponseObject.builder().data(allsession).message("Get successful").responseCode(HttpStatus.OK.value()).build());
    }
}
