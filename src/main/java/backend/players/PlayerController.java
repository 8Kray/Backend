package backend.players;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.repository.support.Repositories;
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
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> playerList = playerService.getAllPlayers();
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    @GetMapping("/name/{playerName}")
    public ResponseEntity<Player> getPlayerByName(@PathVariable String playerName){
        Player player = playerService.getPlayerByName(playerName);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addPlayers(@RequestBody Player players) {
        Player player = playerService.addplayer(players);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}/{playerDetails}")
    public ResponseEntity<Player> updatePlayerDetails(@PathVariable UUID id, @PathVariable String playerDetails) {
        Player updatePlayer = playerService.updatePlayerDetails(id, playerDetails);
        return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{statistic}")
    public ResponseEntity<Player> updatePlayerStatistic(@PathVariable UUID id, @PathVariable String statistic) {
        Player updatePlayer = playerService.updatePlayerStatistic(id, statistic);
        return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/name/{playerName}")
    public ResponseEntity<Void> deletePlayersByName(@PathVariable String playerName) {
        playerService.deletePlayerByName(playerName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}