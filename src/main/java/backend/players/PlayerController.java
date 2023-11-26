package backend.players;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping
    public List<Players> getAllPlayers() {
        return playerRepository.findAll();
    }

    @RequestMapping
    public Players createPlayers(@RequestBody Players players) {
        return playerRepository.save(players);
    }
}