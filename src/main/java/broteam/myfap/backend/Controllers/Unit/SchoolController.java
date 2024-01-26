package broteam.myfap.backend.Controllers.Unit;

import broteam.myfap.backend.Dto.Auth.AuthRequest;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Service.Unit.ISchoolService;
import broteam.myfap.backend.Service.Unit.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unit/school")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SchoolController {
    private final SchoolService schoolService;
    @GetMapping
    public ResponseEntity<ResponseObject> GetAllSchools() {
        List<SchoolDto> allSchools = schoolService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allSchools)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }

}
