package backend.players.util;

import backend.user.util.UserAdminMedia;
import backend.user.util.UserLogInDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayersCreateDto {

    private String playerName;
    private String playerDetails;
    private String statistic;
    private UserAdminMedia users;
}
