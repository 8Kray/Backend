package backend.players;

import backend.players.util.PlayersCreateDto;
import backend.players.util.PlayersDto;
import backend.players.util.PlayersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {


    private final PlayerService playerService;

    @GetMapping("/all")
    public ResponseEntity<List<PlayersDto>> getAllPlayers() {
        List<Players> players = playerService.getAllPlayers();
        List<PlayersDto> playersDtoList = PlayersMapper.mapToDtoList(players);
        return new ResponseEntity<>(playersDtoList, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Players>> getAllPlayerss() {
        List<Players> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Players> addPlayer(@RequestBody PlayersCreateDto players) {
        try {
            Players newPlayer = playerService.addPlayer(players);
            return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlayersDto> getPlayerById(@PathVariable UUID id) {
        Players player = playerService.getPlayerById(id);
        if (player != null) {
            PlayersDto playersDto = PlayersMapper.toDto(player);
            return new ResponseEntity<>(playersDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<PlayersDto> getPlayerByPlayerName(@RequestParam String playerName) {
        Players player = playerService.getPlayerByPlayerName(playerName);
        if (player != null) {
            PlayersDto playersDto = PlayersMapper.toDto(player);
            return new ResponseEntity<>(playersDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update{player}")
    public ResponseEntity<String> updatePlayerByPlayer(@RequestParam String player, @RequestBody PlayersDto playersDto) {
        try {
            playerService.updatePlayerByPlayerName(player, playersDto);
            return ResponseEntity.status(HttpStatus.OK).body("Players updated successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable UUID id) {
        try {
            playerService.deletePlayerById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Players deleted successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}