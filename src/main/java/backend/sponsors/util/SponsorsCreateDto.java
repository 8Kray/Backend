package backend.sponsors.util;

import backend.user.Users;
import backend.user.util.UserAdminMedia;
import backend.user.util.UserLogInDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SponsorsCreateDto {

    private String sponsor;
    private String details;
    private String link;
    private UserAdminMedia users;
}
