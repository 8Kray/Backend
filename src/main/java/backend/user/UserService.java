package backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public Users addUser(Users users) {
        return userRepository.save(users);
    }
}
