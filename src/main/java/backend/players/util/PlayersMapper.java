package backend.players.util;

import backend.players.Players;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class PlayersMapper {
    public static PlayersDto toDto(Players players) {
        PlayersDto playersDto = new PlayersDto();
        playersDto.setPlayerName(players.getPlayerName());
        playersDto.setPlayerDetails(players.getPlayerDetails());
        playersDto.setStatistic(players.getStatistic());
        return playersDto;
    }
    public static List<PlayersDto> mapToDtoList(List<Players> playersList) {
        return playersList.stream()
                .map(PlayersMapper::toDto)
                .collect(Collectors.toList());
    }
}
