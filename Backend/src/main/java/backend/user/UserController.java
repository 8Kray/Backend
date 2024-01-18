package backend.user;

import backend.user.util.DuplicateEmailException;
import backend.user.util.UserDto;
import backend.user.util.UserLogInDto;

import backend.user.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Users> addUser(@RequestBody Users users) throws DuplicateEmailException {
        Users newUser = userService.addUser(users);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody UserLogInDto usersLogin) throws Exception {
       String username = usersLogin.getUsername();
       String password = usersLogin.getPassword();
       return new ResponseEntity<>(userService.login(username, password), HttpStatus.OK);

    }
    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        List<UserDto> userDtoList = UserMapper.mapToUserDTOs(users);
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        Users user = userService.getUserById(id);
        if (user != null) {
            UserDto userDto = UserMapper.userToUserDTO(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-by-username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        Users user = userService.getUserByName(username);
        if (user != null) {
            UserDto userDto = UserMapper.userToUserDTO(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update{users}")
    public ResponseEntity<Users> updateUserByUser(@RequestParam String username, @RequestBody UserDto users) {
        try {
            Users updatedUser = userService.updateUserByUser(username, users);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        Users user = userService.getUserByEmail(email);
        if (user != null) {
            UserDto userDto = UserMapper.userToUserDTO(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}