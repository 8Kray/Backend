package backend.user.util;

import backend.user.Users;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto userToUserDTO(Users users) {
        UserDto userDTO = new UserDto();
        userDTO.setUsername(users.getUsername());
        userDTO.setPassword(users.getPassword());
        userDTO.setEmail(users.getEmail());
        userDTO.setLevel(users.getLevel());
        return userDTO;
    }

    public static Users userDTOToUser(UserDto userDTO) {
        Users users = new Users();
        users.setUsername(userDTO.getUsername());
        users.setPassword(userDTO.getPassword());
        users.setEmail(userDTO.getEmail());
        users.setLevel(userDTO.getLevel());
        return users;
    }
    public static List<UserDto> mapToUserDTOs(List<Users> usersList) {
        return usersList.stream()
                .map(UserMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

}
