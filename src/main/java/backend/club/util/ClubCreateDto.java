package backend.club.util;

import backend.user.util.UserAdminMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubCreateDto {

    private String title;
    private String clubDetails;
    private Date date;
    private UserAdminMedia users;
}
