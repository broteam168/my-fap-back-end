package broteam.myfap.backend.Controllers.User;

import broteam.myfap.backend.Dto.PagedResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @GetMapping
    public ResponseEntity<PagedResponseObject> getPagedUser(@RequestParam(name = "page", defaultValue = "1") int page,
                                                                 @RequestParam(name = "size", defaultValue = "10") int size) {

    }
}
