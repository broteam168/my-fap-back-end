package broteam.myfap.backend.Controllers.Authentication;

import broteam.myfap.backend.Dto.Auth.AuthRequest;
import broteam.myfap.backend.Dto.Auth.AuthResponse;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Service.Auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("login")
    public ResponseEntity<ResponseObject> login(
                                                @RequestBody @Valid AuthRequest authDto
    ) {

        AuthResponse authResponse = authService.authenticate(authDto);

        return ResponseEntity.ok(ResponseObject.builder()
                .data(authResponse)
                .message("login successfully")
                .responseCode(HttpStatus.OK.value())
                .build());

    }


}
