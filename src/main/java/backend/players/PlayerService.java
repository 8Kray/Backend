package backend.players;

import backend.players.util.PlayersDto;
import backend.user.UserRepository;
import backend.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final UserRepository user;

    public List<Players> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Players addPlayer(Players players) throws Exception {
        Users existingUser = user.findByUsername(players.getUsers().getUsername());

        if (existingUser != null) {
            players.getUsers().setId(existingUser.getId());
            players.getUsers().setEmail(existingUser.getEmail());
            players.getUsers().setLevel(existingUser.getLevel());
            return playerRepository.save(players);
        } else {
            throw new Exception("User not found");
        }
    }

    public Players getPlayerById(UUID id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Players getPlayerByPlayerName(String playerName) {
        return playerRepository.findByPlayerName(playerName);
    }

    public void deletePlayerById(UUID id) {
        playerRepository.deleteById(id);
    }

    public void deletePlayerByPlayerName(String playerName) {
        playerRepository.deleteByPlayerName(playerName);
    }

    public void updatePlayerByPlayerName(String playerName, PlayersDto playersDto) {
        Players existingPlayer = playerRepository.findByPlayerName(playerName);
        existingPlayer.setPlayerName(playersDto.getPlayerName());
        existingPlayer.setPlayerDetails(playersDto.getPlayerDetails());
        existingPlayer.setStatistic(playersDto.getStatistic());
        playerRepository.save(existingPlayer);
    }
}
