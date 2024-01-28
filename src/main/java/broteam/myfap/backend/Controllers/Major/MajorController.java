package broteam.myfap.backend.Controllers.Major;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Service.Major.IMajorService;
import broteam.myfap.backend.Service.Major.MajorService;
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
@RequestMapping("/api/v1/major")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MajorController {
    private final IMajorService majorService;
    @GetMapping
    public ResponseEntity<ResponseObject> GetAllMajorBase() {
        System.out.println("abc");
        List<MajorDto> allMajors = majorService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allMajors)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
}
