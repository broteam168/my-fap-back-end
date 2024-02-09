package broteam.myfap.backend.Controllers.Unit;

import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.Unit.ClassDto;
import broteam.myfap.backend.Dto.Unit.ClassRequest;
import broteam.myfap.backend.Dto.Unit.RoomDto;
import broteam.myfap.backend.Dto.Unit.RoomRequestDto;
import broteam.myfap.backend.Exception.Unit.SchoolException;
import broteam.myfap.backend.Service.Unit.ClassService;
import broteam.myfap.backend.Service.Unit.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unit/room")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllRooms() {
        List<RoomDto> allRooms = roomService.findAllBase();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allRooms)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
    @GetMapping("search")
    public ResponseEntity<ResponseObject> getAllClassBySchool(@RequestParam(name = "schoolid") @Valid int schoolId) {
        List<RoomDto> allClasses = roomService.FindBySchoolId(schoolId);
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allClasses)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
    @PostMapping
    public ResponseEntity<ResponseObject> createRoom(@Valid @RequestBody RoomRequestDto newRoom) {
        String returnMessage = "Create Successfully";
        int resposeCode = HttpStatus.OK.value();
        RoomDto returnRoom = new RoomDto();
        try {
            returnRoom = roomService.createNewRoom(newRoom);
        } catch (SchoolException ex) {
            returnMessage = ex.getMessage();
            resposeCode = HttpStatus.ACCEPTED.value();
        } catch (Exception ex2) {
            returnMessage = ex2.getMessage();
            resposeCode = HttpStatus.ACCEPTED.value();
        }
        return ResponseEntity.ok(ResponseObject.builder()
                .data(returnRoom)
                .message(returnMessage)
                .responseCode(resposeCode)
                .build());
    }
}
