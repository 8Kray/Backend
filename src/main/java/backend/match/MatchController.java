package backend.match;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchRepository matchRepository;

    @GetMapping
    public List<Match> getAllMatch() {
        return matchRepository.findAll();
    }

    @RequestMapping
    public Match createMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }
}