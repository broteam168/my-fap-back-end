package broteam.myfap.backend.Controllers.Time;

import broteam.myfap.backend.Converter.Unit.UnitConverter;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.Time.GroupSlotDto;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.SchoolDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Models.Unit.School;
import broteam.myfap.backend.Service.Time.GroupSlotService;
import broteam.myfap.backend.Service.Unit.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/time/groupslot")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GroupSlotController {
    private final GroupSlotService groupSlotService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllGroupSlot() {
        List<GroupSlotDto> allGroup = groupSlotService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allGroup)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
}
