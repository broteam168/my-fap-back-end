package broteam.myfap.backend.Controllers.Time;

import broteam.myfap.backend.Dto.Major.SubMajorDto;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.Time.GroupSlotDto;
import broteam.myfap.backend.Dto.Time.GroupSlotRequestDto;
import broteam.myfap.backend.Dto.Time.SlotDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Service.Time.GroupSlotService;
import broteam.myfap.backend.Service.Time.SlotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.ConcreteCflowPointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/time/slot")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SlotController {
    private final SlotService slotService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllSlot() {
        List<SlotDto> allGroup = slotService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allGroup)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
    @GetMapping("search")
    public ResponseEntity<ResponseObject> getAllSlotBy(@RequestParam(name = "groupId") @Valid int groupId) {
        List<SlotDto> allSlot = slotService.FindByGroupId(groupId);
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allSlot)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
}
