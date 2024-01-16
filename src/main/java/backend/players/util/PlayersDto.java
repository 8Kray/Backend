package backend.players.util;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayersDto {
    @NotBlank
    private String playerName;
    @NotBlank
    private String playerDetails;
    @NotBlank
    private String statistic;
}
