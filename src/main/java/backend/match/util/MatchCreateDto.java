package backend.match.util;

import backend.user.util.UserAdminMedia;
import backend.user.util.UserCreateDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchCreateDto {

    private String teamA;
    private String teamB;
    private Integer teamA_Scor;
    private Integer teamB_Scor;
    private Date date;
    private UserAdminMedia users;
}
