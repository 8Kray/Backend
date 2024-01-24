package backend.club.util;

import backend.user.util.UserAdminMedia;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class ClubCreateDto {

    private String title;
    @Lob
    private String clubDetails;
    private Date date;
    private UserAdminMedia users;
}
