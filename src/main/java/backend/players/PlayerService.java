package backend.players;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {return playerRepository.findAll();}

    public Player addplayer(Player player) {
        return playerRepository.save(player);
    }

    public Player getPlayerByName(String name) {
        return playerRepository.findPlayerByplayerName(name);
    }

    public void deletePlayerByName(String name) {
        playerRepository.deletePlayerByplayerName(name);
    }

    public Player updatePlayerDetails(UUID id, String playerDetails) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setPlayerDetails(playerDetails);
        return playerRepository.save(player);
    }

    public Player updatePlayerStatistic(UUID id, String statistic) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setStatistic(statistic);
        return playerRepository.save(player);
    }
}
