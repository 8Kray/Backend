package backend.match;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    @PostMapping("/add")
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        Match addedMatch = matchService.addMatch(match);
        return new ResponseEntity<>(addedMatch, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> matchList = matchService.getAllMatches();
        return new ResponseEntity<>(matchList, HttpStatus.OK);
    }

    @GetMapping("/name/{teamB}")
    public ResponseEntity<List<Match>> getMatchByName(@PathVariable String teamB) {
        List<Match> matchList = matchService.getMatchByTeamB(teamB);
        return new ResponseEntity<>(matchList, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Match>> getMatchByDate(@PathVariable Date date) {
        List<Match> matchList = matchService.getMatchByDate((Data) date);
        return new ResponseEntity<>(matchList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{teamA_Scor}/{teamB_Scor}")
    public ResponseEntity<Match> updateMatchScore(@PathVariable UUID id, @PathVariable Integer teamA_Scor, @PathVariable Integer teamB_Scor) {
        Match updatedMatch = matchService.updateMatchScore(id, teamA_Scor, teamB_Scor);
        return new ResponseEntity<>(updatedMatch, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}/{teamA}/{teamB}")
    public ResponseEntity<Match> updateMatchTeams(@PathVariable UUID id, @PathVariable String teamA, @PathVariable String teamB) {
        Match updatedMatch = matchService.updateMatchTeams(id, teamA,teamB);
        return new ResponseEntity<>(updatedMatch, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/date/{date}")
    public ResponseEntity<Void> deleteMatchByDate(@PathVariable Date date) {
        matchService.deleteMatchBydate(date);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}