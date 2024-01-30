package broteam.myfap.backend.Controllers.Major;

import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Service.Major.IMajorService;
import broteam.myfap.backend.Service.Major.ISubMajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/submajor")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SubMajorController {
    private final ISubMajorService service;
    @GetMapping
    public ResponseEntity<ResponseObject> GetAllSubMajorBase() {
        List<SubMajorDto> allSubMajors = service.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allSubMajors)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
}
