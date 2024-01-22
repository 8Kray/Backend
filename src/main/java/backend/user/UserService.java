package backend.user;

import backend.user.util.DuplicateEmailException;
import backend.user.util.InvalidEmailFormatException;
import backend.user.util.UserCreateDto;
import backend.user.util.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users login(String username, String password) {
        Users existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            if (existingUser.getPassword().equals(password)) {
                return existingUser;
            }
        }
        return null;
    }


    public Users addUser(UserCreateDto userCreateDto) throws DuplicateEmailException, InvalidEmailFormatException {
        String email = userCreateDto.getEmail();

        // Check if the email already exists in the database
        Users existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            throw new DuplicateEmailException("Email already in use");
        }

        // Check email format (ending with .com or .ro) and domain
        if (!isValidEmailFormat(email)) {
            throw new InvalidEmailFormatException("Invalid email format");
        }

        // Set the default username based on the email address
        int atIndex = email.indexOf('@');
        if (atIndex >= 0) {
            String baseUsername = email.substring(0, atIndex);
            String username = baseUsername;
            int counter = 1;
            while (userRepository.findByUsername(username) != null) {
                username = baseUsername + "_" + counter;
                counter++;
            }

            userCreateDto.setUsername(username);
        } else {
            throw new InvalidEmailFormatException("Invalid email format");
        }

        // Convert UserCreateDto to Users entity and save it
        Users newUser = new Users();
        newUser.setUsername(userCreateDto.getUsername());
        newUser.setPassword(userCreateDto.getPassword());
        newUser.setEmail(userCreateDto.getEmail());

        return userRepository.save(newUser);
    }


    public boolean isValidEmailFormat(String email) {
        return email.matches("^.+@(gmail|yahoo|outlook|student\\.usv)\\.(com|ro)$");
    }


    public Users getUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public Users getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    public Users updateUserByUser(String username, UserDto userDTO) {
        // Find the existing user by username
        Users existingUser = userRepository.findByUsername(username);

        if (existingUser != null) {
            // Update the fields only if the corresponding fields in userDTO are not null
            if (userDTO.getUsername() != null) {
                existingUser.setUsername(userDTO.getUsername());
            }
            if (userDTO.getEmail() != null) {
                existingUser.setEmail(userDTO.getEmail());
            }
            if (userDTO.getLevel() != null) {
                existingUser.setLevel(userDTO.getLevel());
            }

            // Save the updated user
            userRepository.save(existingUser);
        }

        return existingUser;
    }

    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

}



