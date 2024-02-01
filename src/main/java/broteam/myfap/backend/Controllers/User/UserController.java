package broteam.myfap.backend.Controllers.User;

import broteam.myfap.backend.Controllers.BaseController;
import broteam.myfap.backend.Dto.Major.MajorDto;
import broteam.myfap.backend.Dto.PagedResponseObject;
import broteam.myfap.backend.Dto.ResponseObject;
import broteam.myfap.backend.Dto.User.UserDto;
import broteam.myfap.backend.Models.User;
import broteam.myfap.backend.Repository.UserRepository;
import broteam.myfap.backend.Service.Major.IMajorService;
import broteam.myfap.backend.Service.User.IUserService;
import broteam.myfap.backend.Service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final IUserService userService;
    @GetMapping
    public ResponseEntity<ResponseObject> getAllUser(){
        List<UserDto> allUser = userService.fillAllB();
        return ResponseEntity.ok(ResponseObject.builder()
                .data(allUser)
                .message("Get successful")
                .responseCode(HttpStatus.OK.value())
                .build());
    }
    //lấy danh sách user
    @GetMapping("page")
    public ResponseEntity<PagedResponseObject> getPagedUser(@RequestParam(name = "page", defaultValue = "1") int page,
                                                                 @RequestParam(name = "size", defaultValue = "10") int size) {
        long totalItems = userService.countUser();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        List<UserDto> users = userService.getAllUser(page, size);
        return ResponseEntity.ok(PagedResponseObject.builder()
                .page(page)
                .perPage(size)
                .totalItems(totalItems)
                .totalPages(totalPages)
                .responseCode(200)
                .message("Success")
                .data(users)
                .build());
    }
    //lấy chi tiết user theo id
    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getDetailUser(@PathVariable("id") int userId) {
        User user = userService.getDetailUser(userId);
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(user)
                .build());
    }
    //lấy số lượng user
    @GetMapping("count")
    public ResponseEntity<ResponseObject> getCountUser() {
        long countUser = userService.countUser();
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(countUser)
                .build());
    }


}
