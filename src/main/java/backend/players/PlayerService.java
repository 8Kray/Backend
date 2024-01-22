package backend.players;

import backend.players.util.PlayersCreateDto;
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
    private final UserRepository userRepository;

    public boolean isUserAdmin(String username) {
        Users user = userRepository.findByUsername(username);
        return user != null && "admin".equalsIgnoreCase(user.getLevel());
    }
    public List<Players> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Players addPlayer(PlayersCreateDto playersCreateDto) throws Exception {
        Users existingUser = userRepository.findByUsername(playersCreateDto.getUsers().getUsername());

        if (existingUser != null) {
            if(isUserAdmin(existingUser.getUsername())) {
                Players newPlayer = new Players();
                newPlayer.setPlayerName(playersCreateDto.getPlayerName());
                newPlayer.setPlayerDetails(playersCreateDto.getPlayerDetails());
                newPlayer.setStatistic(playersCreateDto.getStatistic());
                newPlayer.setUsers(existingUser);

                return playerRepository.save(newPlayer);
            } else {
                throw new Exception("User does not have admin level");
            }
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
