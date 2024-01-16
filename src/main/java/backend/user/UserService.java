package backend.user;

import backend.user.util.DuplicateEmailException;
import backend.user.util.InvalidEmailFormatException;
import backend.user.util.UserDto;
import lombok.RequiredArgsConstructor;
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

    public Users addUser(Users users) throws DuplicateEmailException {
        String email = users.getEmail();

        // Check if the email already exists in the database
        Users existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            throw new DuplicateEmailException("Email already in use");
        }

        // Check email format (ending with .com or .ro) and domain
        if (!isValidEmailFormat(email)) {
            throw new InvalidEmailFormatException("Invalid email format");
        }

        // Set the username based on the email address
        int atIndex = email.indexOf('@');
        if (atIndex >= 0) {
            String baseUsername = email.substring(0, atIndex);

            // Check if the username already exists, and if so, increment it
            String username = baseUsername;
            int counter = 1;
            while (userRepository.findByUsername(username) != null) {
                username = baseUsername + "_" + counter;
                counter++;
            }

            users.setUsername(username);
        } else {
            throw new InvalidEmailFormatException("Invalid email format");
        }
        // Set the default level to "user"
        users.setLevel("user");

        return userRepository.save(users);
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

    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
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



