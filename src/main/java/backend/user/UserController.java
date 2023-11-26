package backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<Users>getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping
    public Users createUsers(@RequestBody Users users){
        return userRepository.save(users);
    }

}
